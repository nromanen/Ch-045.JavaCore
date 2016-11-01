package net.students.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class SQLConnection  {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_NAME = "STUDENTS";
    static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

            Class.forName(JDBC_DRIVER);

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
