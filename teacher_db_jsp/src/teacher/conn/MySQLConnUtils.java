package teacher.conn;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MySQLConnUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/study";
	private static final String userName = "root";
	private static final String password = "root";
 
public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {

    return getMySQLConnection(userName, password);
	}
 
public static Connection getMySQLConnection(String userName, String password) throws SQLException,
        ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");
 
    Connection conn = DriverManager.getConnection(URL, userName, password);
    return conn;
}
}