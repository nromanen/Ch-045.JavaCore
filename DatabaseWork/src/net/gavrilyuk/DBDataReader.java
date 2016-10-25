package net.gavrilyuk;

import net.gavrilyuk.model.AcademicGroup;
import net.gavrilyuk.model.Mentor;
import net.gavrilyuk.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class DBDataReader {

    private Connection connection;
    private final Statement stmt;
    private ResultSet rs;


    public DBDataReader(Connection conn) throws SQLException {
       // System.out.println("Creating statement...");
        this.connection =  conn;
        this.stmt = connection.createStatement();

    }

    public ArrayList<Student> loadStudents() throws SQLException {
        String sql = "SELECT * FROM student";
        rs = stmt.executeQuery(sql);
        ArrayList<Student> result = new ArrayList<>();
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            Student student = new Student(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth_day"),
                    rs.getInt("book_number"));
            //log values
           // System.out.print("student id: " + id+"name="+rs.getString("first_name")+" "+rs.getString("last_name"));
            result.add(student);
        }
        rs.close();
        return  result;
    }

    public ArrayList<Mentor> loadMentors() throws SQLException {
        String sql = "SELECT * FROM mentor";
        rs = stmt.executeQuery(sql);
        ArrayList<Mentor> mentors = new ArrayList<>();
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            Mentor mentor = new Mentor(
                    rs.getString("first_name"),
                    rs.getString("last_name"));
            //log values
           // System.out.print("mentor id: " + id+" name="+rs.getString("first_name")+" "+rs.getString("last_name"));
            mentors.add(mentor);
        }
        rs.close();
        return mentors;
    }

    public Statement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Connection getConnection() {
        return connection;
    }


    public ArrayList<AcademicGroup> loadGroups() throws SQLException {
        String sql = "SELECT * FROM academic_group " +
                "INNER JOIN mentor ON academic_group.mentor_id=mentor.id " +
                "INNER JOIN student ON academic_group.id=student.group_id ";
        rs = stmt.executeQuery(sql);
        ArrayList<AcademicGroup> mentors = new ArrayList<>();
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            AcademicGroup mentor = new AcademicGroup(
                    rs.getString("title"),
                    new Mentor(rs.getString("first_name"), rs.getString("last_name")));
            //log values
           // System.out.print("group id: " + id + " name=" + rs.getString("title") + " " + rs.getInt("mentor_id")+"mentor name="+
            //        rs.getString("first_name")+" "+ rs.getString("last_name"));
            mentors.add(mentor);
        }
        rs.close();
        return mentors;
    }
}
