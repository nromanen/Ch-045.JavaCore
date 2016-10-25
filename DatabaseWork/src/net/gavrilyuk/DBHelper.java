package net.gavrilyuk;

import net.gavrilyuk.model.AcademicGroup;
import net.gavrilyuk.model.Mentor;
import net.gavrilyuk.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class DBHelper {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "15375900zZ";

    private static DBHelper dbData;

    private ArrayList<Student> students;
    private DBDataReader dateReader;

    private DBHelper() throws ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            dateReader = new DBDataReader(connection);
        } catch (SQLException e) {
            students = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public static DBHelper getInstance() throws ClassNotFoundException {
        if (dbData == null) {
            dbData = new DBHelper();
        }
        return dbData;
    }

    public ArrayList<Student> getStudents() throws SQLException {
        students =  dateReader.loadStudents();
        return students;
    }

    public ArrayList<Mentor> getMentor() throws SQLException {
        return dateReader.loadMentors();
    }

    public DBDataReader getDateReader() {
        return dateReader;
    }

    public ArrayList<AcademicGroup> getAcademicGroup() throws SQLException{
        return  dateReader.loadGroups();
    }
}
