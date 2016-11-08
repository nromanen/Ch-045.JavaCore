package net.students.controller;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import net.students.dao.SQLContract.MentorsEntry;
import net.students.dao.SQLContract.AcademicGroupEntry;
import net.students.dao.SQLDBProvider;
import net.students.model.Mentor;
import net.students.model.UserAccount;
import net.students.util.AppUtils;
import net.students.validate.Validator;
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
 *  Mentors Servlet
 * Created by Igor Gavryliuk on 06.11.2016.
 */
@WebServlet(name = "MentorsServlet",
            urlPatterns = { "/listMentors",
                            "/editMentor",
                            "/deleteMentor"})
public class MentorsServlet extends HttpServlet {


    private SQLDBProvider provider;

    @Override
    public void init() throws ServletException {
        super.init();
        provider = SQLDBProvider.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorString = null;
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        // Check User has logged on
        UserAccount loginedUser = AppUtils.getLoginedUser(session);
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            userPath = "/loginView";
        }
        String mentorId = request.getParameter("mentorId");
        Validator validator = new Validator();
        try {
            request.setAttribute("groups", provider.query(AcademicGroupEntry.TABLE_NAME, null, null, null, null));
            switch (userPath) {
                case "/editMentor": {
                    if (request.getParameter("OK") != null){ //user press OK on editMentor.jsp form
                        String firstName = request.getParameter("firstName");
                        String lastName = request.getParameter("lastName");

                        boolean validationErrorFlag = validator.validateFormMentor(firstName, lastName, request);
                        if (validationErrorFlag) {
                            //todo implement recovery data entered by the user
                            userPath = "/editMentor";//show error on edit form
                        } else {
                            Mentor mentor = new Mentor(firstName, lastName);
                            if( mentorId == null || mentorId.isEmpty() ){ //new mentor
                              int rowInsert = provider.insert(MentorsEntry.TABLE_NAME, mentor);
                              //  System.out.println("insetred count="+rowInsert);
                            } else { //update
                                mentor.setMentorId(Integer.parseInt(mentorId));
                                provider.update(MentorsEntry.TABLE_NAME, mentor);
                            }
                            request.setAttribute("mentors", provider.query(MentorsEntry.TABLE_NAME, null, null, null, null));
                            userPath = "/mentorsListView";//back to list students
                        }
                    }  else if (request.getParameter("Cancel") != null) { //user press cancel on editMentor.jsp form
                        request.setAttribute("mentors", provider.query(MentorsEntry.TABLE_NAME, null, null, null, null));
                        userPath = "/mentorsListView";//back to mentors list page
                    }
                    break;
                }
                case "/deleteMentor":{
                    userPath = "/mentorsListView";
                    if (mentorId != null) {
                        int deletedCount= provider.delete(MentorsEntry.TABLE_NAME, Integer.parseInt(mentorId));
                        request.setAttribute("infoString","Successfully removed "+deletedCount+" record(s)");
                    }
                    request.setAttribute("mentors", provider.query(MentorsEntry.TABLE_NAME, null, null, null, null));
                    break;
                }

            }
        } catch (MySQLIntegrityConstraintViolationException ce) {
            errorString = "Before removing the mentor, first change this mentor in the group(s)!";
            ce.printStackTrace();
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorString = null;
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        UserAccount loginedUser = AppUtils.getLoginedUser(session);
        if (loginedUser == null) {
            userPath = "/loginView";
        }
        try{
            request.setAttribute("groups", provider.query(AcademicGroupEntry.TABLE_NAME, null, null, null, null));
        switch (userPath) {
            case "/listMentors":// load data on mentorsListView.jsp
                userPath = "/mentorsListView";
                request.setAttribute("mentors", provider.query(MentorsEntry.TABLE_NAME, null, null, null, null));
                break;
            case "/editMentor": //load data on editMentors.jsp
                String mentorId = request.getParameter("mentorId");
                if (mentorId != null) {
                    List mentors = provider.query(MentorsEntry.TABLE_NAME, null,
                            MentorsEntry.ID + " = ? ", new String[]{String.valueOf(mentorId)}, null);
                    if (mentors != null && mentors.size() > 0) {
                        Mentor m = (Mentor) mentors.get(0);
                        request.setAttribute("mentor", m);
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
}
