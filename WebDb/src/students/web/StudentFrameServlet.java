package students.web;

import org.joda.time.DateTime;
import students.logic.ManagementSystem;
import students.logic.SQLContract.StudentsEntry;
import students.model.AcademicGroup;
import students.model.Student;
import students.web.forms.MainFrameForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class StudentFrameServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String sId = req.getParameter("studentId");

        if (sId != null && req.getParameter("OK") != null) {
            try {
                // Если ID студента больше 0, то мы редактируем его данные
                if (Integer.parseInt(sId) > 0) {
                    updateStudent(req);
                } // Иначе это новый студент
                else {
                    insertStudent(req);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                throw new IOException(sqle.getMessage());
            } catch (ParseException pe) {
                throw new IOException(pe.getMessage());
            }
        }
        // And now again we get the data to display on the main form
        String gs = req.getParameter(StudentsEntry.ID);
        String bookNumStr = req.getParameter(StudentsEntry.COL_BOOK_NUM);
        int groupId = -1;
        if (gs != null) {
            groupId = Integer.parseInt(gs);
        }
       /* int bookNum = 0;
        if (bookNumStr != null) {
            bookNum = Integer.parseInt(bookNumStr);
        }*/
        MainFrameForm form = new MainFrameForm();
        try {
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            AcademicGroup g = new AcademicGroup();
            g.setGroupId(groupId);
            if (groupId == -1) {
                Iterator i = groups.iterator();
                g = (AcademicGroup) i.next();
            }
            //Collection students = ManagementSystem.getInstance().getStudentsFromGroup(g, bookNum);
            //Collection students = ManagementSystem.getInstance().getAllStudents();
            Collection students = ManagementSystem.getInstance().query("student", null, null, null, null);
            form.setGroupId(g.getGroupId());
            form.setBookNum(bookNumStr);
            form.setGroups(groups);
            form.setStudents(students);
        } catch (SQLException  | ParseException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateStudent(HttpServletRequest req) throws SQLException, ParseException {
        Student s = prepareStudent(req);
        ManagementSystem.getInstance().updateStudent(s);
    }

    private void insertStudent(HttpServletRequest req) throws SQLException, ParseException {
        Student s = prepareStudent(req);
        ManagementSystem.getInstance().insertStudent(s);
    }

    private Student prepareStudent(HttpServletRequest req) throws ParseException {
        Student s = new Student();
        s.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        s.setFirstName(req.getParameter("firstName").trim());
        s.setLastName(req.getParameter("lastName").trim());
        s.setDateOfBirthdy(DateTime.parse(req.getParameter("dateOfBirthdy").trim()));
        s.setGroupId(Integer.parseInt(req.getParameter("groupId").trim()));
        s.setTestBookNumber(Integer.parseInt(req.getParameter("testBookNumber").trim()));
        return s;
    }
}
