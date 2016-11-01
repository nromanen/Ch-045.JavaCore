package students.web;

import students.logic.ManagementSystem;
import students.model.AcademicGroup;
import students.web.forms.GroupForm;
import students.web.forms.GroupsForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * Created by Igor Gavrilyuk on 29.10.2016.
 */

@WebServlet(name = "GroupsFrameServlet")
public class GroupsFrameServlet extends HttpServlet {

    private static final int ACTION_DELETE = 0;
    private static final int ACTION_ADD = 1;
    private static final int ACTION_EDIT = 2;


    // Check what action we need to do - and returns a response
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Add") != null) {
            return ACTION_ADD;
        }
        if (req.getParameter("Edit") != null) {
            return ACTION_EDIT;
        }
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("groupId") != null) {
                AcademicGroup group = new AcademicGroup();
                group.setGroupId(Integer.parseInt(req.getParameter("groupId")));
                ManagementSystem.getInstance().deleteGroup(group);
            }
            return ACTION_DELETE;
        }
        return ACTION_DELETE;
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Set encoding for the adoption of parameters
        req.setCharacterEncoding("UTF-8");
        int answer;
        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        if (answer == ACTION_ADD) {//add new
            // You've got to make a call to another form, which will redirect servlet
            // to another JSP to enter a new student data
            try {
                AcademicGroup group = new AcademicGroup();
                group.setGroupId(0);
                Collection mentors = ManagementSystem.getInstance().getAllMentors();
                GroupForm gForm = new GroupForm();
                gForm.initFromGroup(group);
                gForm.setMentors(mentors);
                req.setAttribute("group_form", gForm);
                getServletContext().getRequestDispatcher("/GroupFrame.jsp").forward(req, resp);
                return;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }

        }
        if (answer == ACTION_EDIT) {//edit mentor
            try {
                if (req.getParameter("groupId") != null) {
                    int gId = Integer.parseInt(req.getParameter("groupId"));
                    AcademicGroup group = ManagementSystem.getInstance().getGroupById(gId);
                    Collection mentors = ManagementSystem.getInstance().getAllMentors();
                    GroupForm gForm = new GroupForm();
                    gForm.initFromGroup(group);
                    gForm.setMentors(mentors);
                    req.setAttribute("group_form", gForm);
                    getServletContext().getRequestDispatcher("/GroupFrame.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }

        //groups form
        GroupsForm groupsForm = new GroupsForm();
        try {
            Collection mentors = ManagementSystem.getInstance().getAllMentors();
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            groupsForm.setMentors(mentors);
            groupsForm.setGroups(groups);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("groups_form", groupsForm);
        getServletContext().getRequestDispatcher("/GroupsFrame.jsp").forward(req, resp);
    }



    // Redefine the standard methods
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
