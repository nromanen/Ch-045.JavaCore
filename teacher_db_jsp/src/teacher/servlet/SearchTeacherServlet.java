package teacher.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.model.Teacher;
import teacher.utils.DBUtils;
import teacher.utils.MyUtils;

@WebServlet(urlPatterns = { "/searchTeacher" })
public class SearchTeacherServlet extends HttpServlet  {
	 private static final long serialVersionUID = 1L;
	 
	    public SearchTeacherServlet() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Connection conn = MyUtils.getStoredConnection(request);
	 
	        String searchName = (String) request.getParameter("firstName");
	        Teacher teacher = null;
	 
	        String errorString = null;
	        List<Teacher> list = null;
	        try {
	            list = DBUtils.findTeacher(conn, searchName);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 	         
	        // If no error.
	        // Redirect to productList page.
	        if (errorString != null && teacher == null) {
	            response.sendRedirect(request.getServletPath() + "/teacherSearch");
	            return;
	        }
	 
	        // Store errorString in request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("teacherSearch", list);
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/searchTeacherView.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	        
	    }

}
