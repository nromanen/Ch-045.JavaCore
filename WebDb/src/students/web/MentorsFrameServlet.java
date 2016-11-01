package students.web;

import students.logic.ManagementSystem;
import students.model.Mentor;
import students.web.forms.MentorForm;
import students.web.forms.MentorsForm;

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

@WebServlet(name = "MentorsFrameServlet")
public class MentorsFrameServlet extends HttpServlet implements Actions{


    // Check what action we need to do - and returns a response
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Add") != null) {
            return ACTION_ADD;
        }
        if (req.getParameter("Edit") != null) {
            return ACTION_EDIT;
        }
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("mentorId") != null) {
                Mentor mentor = new Mentor();
                mentor.setId(Integer.parseInt(req.getParameter("mentorId")));
                ManagementSystem.getInstance().deleteMentor(mentor);
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
                Mentor mentor = new Mentor();
                mentor.setId(0);
                Collection groups = ManagementSystem.getInstance().getAllGroups();
                MentorForm mForm = new MentorForm();
                mForm.initFromMentor(mentor);
                mForm.setGroups(groups);
                req.setAttribute("mentor", mForm);
                getServletContext().getRequestDispatcher("/MentorFrame.jsp").forward(req, resp);
                return;
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }

        }
        if (answer == ACTION_EDIT) {//edit mentor
            try {
                if (req.getParameter("mentorId") != null) {
                    int mId = Integer.parseInt(req.getParameter("mentorId"));
                    Mentor mentor = ManagementSystem.getInstance().getMentorById(mId);
                    System.out.println(mentor.toString());
                    Collection groups = ManagementSystem.getInstance().getAllGroups();
                    MentorForm mForm = new MentorForm();
                    mForm.initFromMentor(mentor);
                    mForm.setGroups(groups);
                    req.setAttribute("mentor", mForm);
                    getServletContext().getRequestDispatcher("/MentorFrame.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }

        //mentors form
        MentorsForm mentorsForm = new MentorsForm();
        try {
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            Collection mentors = ManagementSystem.getInstance().getAllMentors();
            mentorsForm.setGroups(groups);
            mentorsForm.setMentors(mentors);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("mentors_form", mentorsForm);
        getServletContext().getRequestDispatcher("/MentorsFrame.jsp").forward(req, resp);
    }



    // Redefine the standard methods
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
