package students.web;

import students.logic.ManagementSystem;
import students.model.Mentor;
import students.web.forms.MentorsForm;

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
public class MentorFrameServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // set encoding for input params
        req.setCharacterEncoding("UTF-8");
        String mId = req.getParameter("mentorId");
        // if user press ÎÊ – update data (add new mentor)
        if (mId != null  && req.getParameter("OK") != null) {
            try {
                // if ID mentor > 0, editing data
                if (Integer.parseInt(mId) > 0) {
                    updateMentor(req);
                } // else this is new  mentor
                else {
                    insertMentor(req);
                }
            } catch (SQLException sql_e) {
                sql_e.printStackTrace();
                throw new IOException(sql_e.getMessage());
            } catch (ParseException p_e) {
                throw new IOException(p_e.getMessage());
                /*PrintWriter out = resp.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Empty value');");
                out.println("location='MentorFrame.jsp';");
                out.println("</script>");*/
            }
        }
        // receive data for display to main form
        MentorsForm form = new MentorsForm();
        try {
            Collection groups = ManagementSystem.getInstance().getAllGroups();
            Collection mentors = ManagementSystem.getInstance().getAllMentors();
            form.setGroups(groups);
            form.setMentors(mentors);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("mentors_form", form);
        getServletContext().getRequestDispatcher("/MentorsFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateMentor(HttpServletRequest req) throws SQLException, ParseException {
        Mentor mentor = prepareMentor(req);
        ManagementSystem.getInstance().updateMentor(mentor);
    }

    private void insertMentor(HttpServletRequest req) throws SQLException, ParseException {
        Mentor mentor = prepareMentor(req);
        ManagementSystem.getInstance().insertMentor(mentor);
    }

    private Mentor prepareMentor(HttpServletRequest req) throws ParseException {
        Mentor mentor = new Mentor();
        mentor.setId(Integer.parseInt(req.getParameter("mentorId")));
        mentor.setFirstName(req.getParameter("firstName").trim());
        mentor.setLastName(req.getParameter("lastName").trim());
        mentor.setGroupId(Integer.parseInt(req.getParameter("groupId").trim()));
        return mentor;
    }
}
