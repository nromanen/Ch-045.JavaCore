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
 
@WebServlet(urlPatterns = { "/doCreateTeacher" })
public class DoCreateTeacherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoCreateTeacherServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
             
       String firstName = (String) request.getParameter("firstName");
       String lastName = (String) request.getParameter("lastName");
       
    // first name and last name is the string literal [a-zA-Z_0-9]
       String errorString = null;
       String regex = "\\w+";
 
       if (firstName.isEmpty() || !firstName.matches(regex)) {
           errorString = "Incorrect firsn name!\n";
       }
       if (lastName.isEmpty() || !lastName.matches(regex)) {
           errorString += "incorrect last name!";
       }
      
       Teacher teacher = new Teacher();
       teacher.setFirstName(firstName);
       teacher.setLastName(lastName);
       
       if (errorString == null) {
           try {
               DBUtils.insertTeacher(conn, teacher);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("teacher", teacher);
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/createTeacherView.jsp");
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
