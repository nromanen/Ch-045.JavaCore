package net.students.controller;

import net.students.dao.SQLContract.StudentsEntry;
import net.students.dao.SQLDBProvider;
import net.students.dao.SQLUtils;
import net.students.model.Student;
import net.students.model.UserAccount;
import net.students.util.AppUtils;
import net.students.validate.Validator;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * Created by Igor Gavryliuk on 02.11.2016.
 */
@WebServlet(name = "StudentsServlet",
            loadOnStartup = 1,
            urlPatterns = { "/listStudent",
                            "/editStudent",
                            "/deleteStudent"})
public class StudentsServlet extends HttpServlet {

    private SQLDBProvider provider;
    private final static int RECORDS_PER_PAGE = 100;
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        provider = new SQLDBProvider();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorString = null;
        int page = 1;
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        UserAccount loginedUser = AppUtils.getLoginedUser(session);
        if (loginedUser == null)  userPath = "/loginView";
        try{
            request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
            switch (userPath) {
                case "/listStudent":// load data
                    userPath = "/studentListView";
                    if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
                    String firstName = request.getParameter("firstName");
                    String lastName  = request.getParameter("lastName");
                    String testBookNum = request.getParameter("testBookNumber");
                    String  groupId = request.getParameter("groupId");
                    String selection = SQLUtils.buildSelectionFormFilter(firstName, lastName, testBookNum, groupId);
                    String[] selectionArgs =  SQLUtils.buildSelectionArgsFilter(firstName, lastName, testBookNum, groupId);
                    request.setAttribute("students", provider.queryStudents(null, selection, selectionArgs, null,
                            String.valueOf((page - 1) * RECORDS_PER_PAGE),String.valueOf(RECORDS_PER_PAGE)));
                    int numOfRecords = provider.getNumOfRecordsStudents();
                    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / RECORDS_PER_PAGE);
                    request.setAttribute("numOfPages", numOfPages);
                    request.setAttribute("currentPage", page);
                    StudentFilterForm filterForm = new StudentFilterForm();// restore filter values
                    filterForm.setFirstName(firstName);
                    filterForm.setLastName(lastName);
                    filterForm.setTestBookNumber(testBookNum);
                    if (!AppUtils.isEmpty(groupId))  filterForm.setGroupId(Integer.parseInt(groupId));
                    request.setAttribute("filter_form", filterForm);
                    break;
                case "/editStudent": //load data
                    String studentId = request.getParameter("studentId");
                    if (studentId != null) {
                        List students = provider.queryStudents(null, StudentsEntry.ID + " = ? ", new String[]{String.valueOf(studentId)}, null);
                        if (students != null && students.size() > 0) {
                            Student s = (Student) students.get(0);
                            request.setAttribute("student", s);
                        }
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString!=null) {
            request.setAttribute("errorString", errorString);
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/views" + userPath + ".jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorString = null;
        String userPath = request.getServletPath();
        String studentId = request.getParameter("studentId");
        Validator validator = new Validator();
        try {
            request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
            switch (userPath) {
                case "/editStudent":
                    if (request.getParameter("OK") != null) {
                        String dateOfBirth = request.getParameter("dateOfBirth");
                        String testBookNumber = request.getParameter("testBookNumber");
                        String groupId = request.getParameter("groupId");
                        String firstName = request.getParameter("firstName");
                        String lastName = request.getParameter("lastName");
                        // validate student data
                        boolean validationErrorFlag = validator.validateForm(firstName, lastName, dateOfBirth, testBookNumber,  request);
                        if (validationErrorFlag) {
                            request.setAttribute("validationErrorFlag", true);
                            userPath = "/editStudent";//back to list students
                        } else {
                            Student student = new Student();
                            student.setGroupId(Integer.parseInt(groupId));
                            student.setFirstName(firstName);
                            student.setLastName(lastName);
                            student.setTestBookNumber(Integer.parseInt(testBookNumber));
                            student.setDateOfBirth(DateTime.parse(dateOfBirth));
                            if (studentId == null || studentId.isEmpty()) { //new student
                                int rowInsert = provider.insertStudent(student);
                            } else { //update
                                student.setStudentId(Integer.parseInt(studentId));
                                provider.updateStudent(student);
                            }
                            getRequestedPage(request);
                            userPath = "/studentListView";//back to list students
                        }
                    } else if (request.getParameter("Cancel") != null) { //user press cancel on editMentor.jsp form
                        getRequestedPage(request);
                        userPath = "/studentListView";//back to list students
                    }
                    break;
                case "/deleteStudent":
                    userPath = "/studentListView";//back to list students
                    if (studentId != null) {
                        int deletedCount = provider.deleteStudent(Integer.parseInt(studentId));
                        request.setAttribute("infoString","Successfully removed "+deletedCount+" record(s)");
                    }
                    getRequestedPage(request);
                    break;
            }
        } catch(SQLException | IllegalArgumentException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString!=null) {
            request.setAttribute("errorString", errorString);
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/views" + userPath + ".jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }


    private void getRequestedPage( HttpServletRequest request) throws SQLException{
        int page= 1;
        if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
        request.setAttribute("students", provider.queryStudents(null, null, null, null,
                String.valueOf((page - 1) * RECORDS_PER_PAGE), String.valueOf(RECORDS_PER_PAGE)));
        int numOfRecords = provider.getNumOfRecordsStudents();
        System.out.println("numOfRecords="+numOfRecords);
        int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / RECORDS_PER_PAGE);
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", page);
    }

}


