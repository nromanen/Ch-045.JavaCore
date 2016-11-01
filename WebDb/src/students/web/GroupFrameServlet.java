package students.web;

import students.logic.ManagementSystem;
import students.model.AcademicGroup;
import students.web.forms.GroupsForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;

/**
 *
 * Created by Igor Gavrilyuk on 29.10.2016.
 */
public class GroupFrameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // set encoding for input params
        req.setCharacterEncoding("UTF-8");
        String gId = req.getParameter("groupId");
        // if user press ÎÊ – update data (add new mentor)
        if (gId != null  && req.getParameter("OK") != null) {
            try {
                // if ID group > 0, editing data
                if (Integer.parseInt(gId) > 0) {
                    updateGroup(req);
                } // else this is new  group
                else {
                    insertGroup(req);
                }
            } catch (SQLException sql_e) {
                sql_e.printStackTrace();
                throw new IOException(sql_e.getMessage());
            } catch (ParseException p_e) {
                throw new IOException(p_e.getMessage());

            }
        }
        // And now again we get the data to display on the main form
        GroupsForm form = new GroupsForm();
        try {
            Collection mentors = ManagementSystem.getInstance().getAllMentors();
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            form.setMentors(mentors);
            form.setGroups(groups);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("groups_form", form);
        getServletContext().getRequestDispatcher("/GroupsFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateGroup(HttpServletRequest req) throws SQLException, ParseException {
        AcademicGroup group = prepareGroup(req);
        ManagementSystem.getInstance().updateGroup(group);
    }

    private void insertGroup(HttpServletRequest req) throws SQLException, ParseException {
        AcademicGroup group = prepareGroup(req);
        ManagementSystem.getInstance().insertGroup(group);
    }

    private AcademicGroup prepareGroup(HttpServletRequest req) throws ParseException {
        AcademicGroup group = new AcademicGroup();
        group.setGroupId(Integer.parseInt(req.getParameter("groupId").trim()));
        group.setTitle(req.getParameter("title").trim());
        group.setMentor(Integer.parseInt(req.getParameter("mentor")));
        return group;
    }
}
