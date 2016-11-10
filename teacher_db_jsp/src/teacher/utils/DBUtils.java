package teacher.utils;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import teacher.model.Category;
import teacher.model.Department;
import teacher.model.Positions;
import teacher.model.Product;
import teacher.model.Teacher;
 
public class DBUtils {
	
	private final static String GET_ALL_TECHER = "SELECT t.id, t.firstName, t.lastName, t.position, t.date_birthday, t.department, t.qualifying_cat, t.load  FROM teacher t;";
	private final static String GET_ALL_DEPARTMENT="SELECT d.id, d.title FROM department d;";
	private final static String FIND_TEACHER = "SELECT t.id, t.firstName, t.lastName FROM teacher t WHERE t.id=?;";
	private final static String SEARCH_TEACHER = "SELECT t.id, t.firstName, t.lastName FROM teacher t WHERE t.firstName=?"; 
	private final static String UPDATE_TEACHER = "UPDATE teacher SET firstName=?, lastName=? WHERE id=?; ";
	private final static String INSERT_TEACHER = "INSERT INTO teacher (firstName, lastName) VALUES (?, ?);";
	private final static String DELETE_TEACHER = "DELETE FROM teacher WHERE id= ?;";
	
  public static List<Teacher> queryTeacher(Connection conn) throws SQLException {
 
      PreparedStatement pstm = conn.prepareStatement(GET_ALL_TECHER);
 
      ResultSet rs = pstm.executeQuery();
      List<Teacher> list = new ArrayList<Teacher>();
      while (rs.next()) {

          Teacher teacher = new Teacher();    
          teacher.setId(rs.getInt("id"));
          teacher.setFirstName(rs.getString("firstName"));
          teacher.setLastName(rs.getString("lastName"));
          teacher.setPosition(Positions.valueOf(rs.getString("position")));
          teacher.setDateOfBirthday(rs.getDate("date_birthday"));
          teacher.setDepartmentId(rs.getInt("department"));
          teacher.setQualifyingCategory(Category.valueOf(rs.getString("qualifying_cat")));
          teacher.setLoad(rs.getInt("load"));
          
          list.add(teacher);
      }
      return list;
  }
  
  public static List<Department> queryDepartment(Connection conn) throws SQLException {
	  PreparedStatement pstm = conn.prepareStatement(GET_ALL_DEPARTMENT);
	  
      ResultSet rs = pstm.executeQuery();
      List<Department> list = new ArrayList<Department>();
      while (rs.next()) {

    	  Department department = new Department();
    	  department.setId(rs.getInt("id"));
    	  department.setTitle(rs.getString("title"));
     
          list.add(department);
      }
	  return list;
  }
 
  public static Teacher findTeacher(Connection conn, int id) throws SQLException {
 
      PreparedStatement pstm = conn.prepareStatement(FIND_TEACHER);
      pstm.setInt(1, id);
 
      ResultSet rs = pstm.executeQuery();
 
      while (rs.next()) {
          Teacher teacher = new Teacher();
    
          teacher.setId(id);
          teacher.setFirstName(rs.getString("firstName"));
          teacher.setLastName(rs.getString("lastName"));
          
          return teacher;
      }
      return null;
  }
  
  public static List<Teacher> findTeacher(Connection conn, String firstName) throws SQLException {
      
      PreparedStatement pstm = conn.prepareStatement(SEARCH_TEACHER);
      pstm.setString(1, firstName);
 
      ResultSet rs = pstm.executeQuery();
      List<Teacher> list = new ArrayList<Teacher>();
      while (rs.next()) {
          Teacher teacher = new Teacher();
         
          teacher.setId(rs.getInt("id"));
          teacher.setFirstName(rs.getString("firstName"));
          teacher.setLastName(rs.getString("lastName"));
          list.add(teacher);
          
      }
      return list;
  }
 
  public static void updateTeacher(Connection conn, Teacher teacher) throws SQLException {
     
	  PreparedStatement pstm = conn.prepareStatement(UPDATE_TEACHER);
      
      pstm.setString(1, teacher.getFirstName());
      pstm.setString(2, teacher.getLastName());
      pstm.setInt(3, teacher.getId());
      
      pstm.executeUpdate();
  }
 
  public static void insertTeacher(Connection conn, Teacher teacher) throws SQLException {
	   
      PreparedStatement pstm = conn.prepareStatement(INSERT_TEACHER);
 
      pstm.setString(1, teacher.getFirstName());
      pstm.setString(2, teacher.getLastName());
      //pstm.setString(3, String.valueOf(teacher.getPosition()));
 
      pstm.executeUpdate();
  }
 
  public static void deleteProduct(Connection conn, int id) throws SQLException {
       
      PreparedStatement pstm = conn.prepareStatement(DELETE_TEACHER);
      System.out.print(id);
 
      pstm.setInt(1, id);
 
      pstm.executeUpdate();
  }
 
}
