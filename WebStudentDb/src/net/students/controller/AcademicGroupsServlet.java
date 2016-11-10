package net.students.controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import net.students.dao.SQLContract.AcademicGroupEntry;
import net.students.dao.SQLContract.StudentsEntry;
import net.students.dao.SQLDBProvider;
import net.students.model.AcademicGroup;
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
 *
 * Created by Igor Gavryliuk on 04.11.2016.
 */
@WebServlet(name = "AcademicGroupsServlet",
            urlPatterns = {"/listGroup",
                           "/editGroup",
                           "/deleteGroup"})
public class AcademicGroupsServlet extends HttpServlet {


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
        UserAccount loginedUser = AppUtils.getLoginedUser(session);
        if (loginedUser == null) userPath = "/loginView";
        String groupId = request.getParameter("groupId");
        Validator validator = new Validator();
        try {
            request.setAttribute("mentors", provider.queryMentors(null, null, null, null));
            switch (userPath) {
                case "/editGroup": {
                    userPath = "/editAcademicGroup";//show error on edit form
                    if (request.getParameter("OK") != null) { //user press OK
                        String title = request.getParameter("title");
                        String mentorId = request.getParameter("mentorId");
                        boolean validationErrorFlag = validator.validateFormGroup(title, request);
                        if (validationErrorFlag) {
                            request.setAttribute("validationErrorFlag", true);
                            userPath = "/editAcademicGroup";//show error on edit form
                        } else {
                            userPath = "/groupsListView";//back to list students
                            AcademicGroup academicGroup = new AcademicGroup();
                            academicGroup.setTitle(title);
                            academicGroup.setMentorId(Integer.parseInt(mentorId));
                            if (groupId == null || groupId.isEmpty()) { //new mentor
                                int rowInsert = provider.insertAcademicGroup(academicGroup);
                            } else { //update
                                academicGroup.setGroupId(Integer.parseInt(groupId));
                                provider.updateAcademicGroup(academicGroup);
                            }
                            request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
                        }
                    } else if (request.getParameter("Cancel") != null) { //user press cancel
                        request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
                        userPath = "/groupsListView";//back to
                    }
                    break;
                }
                case "/deleteGroup": {
                    userPath = "/groupsListView";
                    if (groupId != null) {
                            int deletedCount = provider.deleteAcademicGroup(Integer.parseInt(groupId));
                            request.setAttribute("infoString","successfully removed "+deletedCount+" record(s)");
                    }
                    request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
                    break;
                }

            }
        }  catch (MySQLIntegrityConstraintViolationException ce) {
            errorString = "Before removing the group, first move the students in the other group(s)!";
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
        // Check User has logged on
        UserAccount loginedUser = AppUtils.getLoginedUser(session);
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            userPath = "/loginView";
        }
        try{
            request.setAttribute("mentors", provider.queryMentors(null, null, null, null));
            switch (userPath) {
                case "/listGroup"://
                    userPath = "/groupsListView";
                    request.setAttribute("groups", provider.queryAcademicGroups(null, null, null, null));
                    break;
                case "/editGroup": //lo
                    System.out.println(" do get editGroup");
                    userPath = "/editAcademicGroup";
                    String groupId = request.getParameter("groupId");
                    if (groupId != null) {
                        List groups = provider.queryAcademicGroups(null, AcademicGroupEntry.ID + " = ? ",
                                new String[]{String.valueOf(groupId)}, null);
                        if (groups != null && groups.size() > 0) {
                            AcademicGroup group = (AcademicGroup) groups.get(0);
                            request.setAttribute("group", group);
                        }
                        request.setAttribute("students",
                                provider.queryStudents(null, StudentsEntry.COL_GROUP_ID + " = ? ",
                                        new String[]{groupId}, null));
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null) {
            request.setAttribute("errorString", errorString);
        }
        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/views" + userPath + ".jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
}
