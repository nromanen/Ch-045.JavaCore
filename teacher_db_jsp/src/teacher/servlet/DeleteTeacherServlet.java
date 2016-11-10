package teacher.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.utils.DBUtils;
import teacher.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/deleteTeacher" })
public class DeleteTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteTeacherServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int id = Integer.parseInt(request.getParameter("id"));
 
        String errorString = null;
 
        try {
            DBUtils.deleteProduct(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
         
 
        if (errorString != null) {
 
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            //
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteTeacherErrorView.jsp");
            dispatcher.forward(request, response);
        }
 
        else {
            response.sendRedirect(request.getContextPath() + "/teacherList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}