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

import teacher.model.Teacher;
import teacher.utils.DBUtils;
import teacher.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/doEditTeacher" })
public class DoEditTeacherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoEditTeacherServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       int id = Integer.parseInt(request.getParameter("id"));
       String firstName = (String) request.getParameter("firstName");
       String lastName = (String) request.getParameter("lastName");
       
       Teacher teacher = new Teacher();
      
       teacher.setId(id);
       teacher.setFirstName(firstName);
       teacher.setLastName(lastName);
 
       String errorString = null;
 
       try {
           DBUtils.updateTeacher(conn, teacher);
       } catch (SQLException e) {
           e.printStackTrace();
           errorString = e.getMessage();
       }
 
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("teacher", teacher);
 
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/editTeacherView.jsp");
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