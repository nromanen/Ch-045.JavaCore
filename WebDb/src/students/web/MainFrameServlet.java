package students.web;

import org.joda.time.DateTime;
import students.logic.ManagementSystem;
import students.logic.SQLUtils;
import students.model.Student;
import students.web.forms.MainFrameForm;
import students.web.forms.StudentForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class MainFrameServlet extends HttpServlet implements Actions
{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Set encoding for the adoption of parameters
        req.setCharacterEncoding("UTF-8");
        int answer = 0;
        MainFrameForm mainFrameForm = new MainFrameForm();

        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        if (answer == ACTION_ADD) {//add
            // You've got to make a call to another form, which will redirect servlet
            // to another JSP to enter a new student data
            try {
                Student s = new Student();
                s.setStudentId(0);
                s.setDateOfBirthdy(DateTime.parse("2000-01-01"));
                s.setTestBookNumber(1);
                Collection groups = ManagementSystem.getInstance().getAllGroups();
                StudentForm sForm = new StudentForm();
                sForm.initFromStudent(s);
                sForm.setGroups(groups);
                req.setAttribute("student_form", sForm);
                getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req, resp);
                return;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }

        }
        if (answer == ACTION_DELETE) {
            if (req.getParameter("studentId") != null) {
                Student s = new Student();
                s.setStudentId(Integer.parseInt(req.getParameter("studentId")));
                try {
                    ManagementSystem.getInstance().deleteStudent(s);
                } catch (SQLException sql_e) {
                    throw new IOException(sql_e.getMessage());
                }
            }
        }
        //edit
        if (answer == ACTION_EDIT) {
            try {
                if (req.getParameter("studentId") != null) {
                    int stId = Integer.parseInt(req.getParameter("studentId"));
                    Student s = ManagementSystem.getInstance().getStudentById(stId);
                    Collection groups = ManagementSystem.getInstance().getAllGroups();
                    StudentForm sForm = new StudentForm();
                    sForm.initFromStudent(s);
                    sForm.setGroups(groups);
                    req.setAttribute("student_form", sForm);
                    getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }
        String gs = req.getParameter("groupId");
        String oldBookNumStr = req.getParameter("bookNum");
        String name = req.getParameter("fullName");
        if (answer == ACTION_CHANGE_GROUP) {    // Here we move the student to another group
             String newGs = req.getParameter("newGroupId");

            try {
                if (req.getParameter("studentId") != null) {
                    int stId = Integer.parseInt(req.getParameter("studentId"));
                    int ngId = Integer.parseInt(newGs);
                    System.out.println("newGroup=" + ngId + " studentId=" + stId);
                    ManagementSystem.getInstance().moveStudentToGroup(ngId, stId);
                    // Now we will show the group that moved
                    gs = newGs;
                    //oldBookNumStr = newBookNumStr;
                } else {
                    //req.setAttribute("errorMessage", "Please select student first!.");
                   // req.getRequestDispatcher("/Errors.jsp").forward(req, resp);
                    mainFrameForm.setError("Please select student first!.");
                }


            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }
        int groupId = -1;
        if (gs != null) {
            groupId = Integer.parseInt(gs);
        }


        try {
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            //fill filter query data
            String selection = null;
            String[] selectionArgs = null;
            Map<String,String> selections = new LinkedHashMap<>();
            if (!SQLUtils.isEmpty(oldBookNumStr)) {
                int bookNum = Integer.parseInt(oldBookNumStr);//for check valid num
                selections.put("book_number",String.valueOf(bookNum));
            }
            if (!SQLUtils.isEmpty(name) ) {
                selections.put("first_name","'" + name + "'");
            }
            if (groupId > 0) {
                selections.put("group_id", String.valueOf(groupId));
            }
            int i = 1;
            StringBuilder selectionBuilder = new StringBuilder();
            for (String s : selections.keySet()) {
                if (i < selections.size() && selections.size() > 1) {
                    selectionBuilder.append(s).append(" = ? AND ");
                } else {
                    selectionBuilder.append(s).append(" = ? ");
                }
                i++;
            }
            selection = selectionBuilder.length() > 0 ? selectionBuilder.toString() : null;
            selectionArgs = selections.values().toArray(new String[selections.size()]);
            System.out.println("selection=" + selection);//for log
            for (String selectionArg : selectionArgs) {
                System.out.println("Arg="+selectionArg);
            }
            //Collection students = ManagementSystem.getInstance().getStudentsFromGroup(g, bookNum);
            //Collection students = ManagementSystem.getInstance().getAllStudents();
            Collection students = ManagementSystem.getInstance().query("student", null, selection, selectionArgs, null);
            mainFrameForm.setGroupId(-1);//
            mainFrameForm.setBookNum(oldBookNumStr);
            mainFrameForm.setGroups(groups);
            mainFrameForm.setStudents(students);
        } catch (SQLException | ParseException sql_e ) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("form", mainFrameForm);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    // Check what action we need to do - and returns a response
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Add") != null) {
            return ACTION_ADD;
        }
        if (req.getParameter("Edit") != null) {
            return ACTION_EDIT;
        }
        if (req.getParameter("MoveGroup") != null) {
            return ACTION_CHANGE_GROUP;
        }
        if (req.getParameter("Delete") != null) {
            return ACTION_DELETE;
        }
        return ACTION_UNKNOWN;
    }

    // Redefine the standard methods
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
