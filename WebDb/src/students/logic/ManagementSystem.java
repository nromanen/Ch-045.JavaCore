package students.logic;

import students.model.AcademicGroup;
import students.model.Mentor;
import students.model.Student;
import students.logic.SQLContract.AcademicGroupEntry;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Management Students System class
 * Created by Igor Gavryliuk on 29.10.2016.
 */

public class ManagementSystem
{
    static final int STUDENT = 100;
    static final int STUDENT_WITH_ID = 101;
    static final int MENTOR = 102;
    static final int MENTOR_WITH_ID = 103;
    static final int GROUP = 104;

    public static int  tableMatcher(String table) {
        if (table.equalsIgnoreCase(SQLContract.StudentsEntry.TABLE_NAME)) {
            return STUDENT;
        }
        if (table.equalsIgnoreCase(SQLContract.MentorsEntry.TABLE_NAME)) {
            return MENTOR;
        }
        if (table.equalsIgnoreCase(SQLContract.AcademicGroupEntry.TABLE_NAME)) {
            return GROUP;
        }
        return -1;
    }

    private static Connection con;
    private static ManagementSystem instance;


    private ManagementSystem() {
    }

    //
    // 1. Якщо ми беремо один коннекшен(con) і використовуємо тільки його то чи можна його не закривати?
    //    Чи краще переробити так, щоб кожен раз брати з пулу новий коннект?
    // 2. Запитання на рахунок директиви synchronized в методі getInstance():
    //    Що в даному випадку є потоком? Як довго він буде жити?
    //    Чи вірно я розумію потік виникає, коли приходить get ріквест на сервер (тобто приходить юзер)
    //    і закінчується після того, як на ріквест відправляється відповідь. Чи так це?

    // 3.Чи як варіант коректно було б при кожному запиті запросити коннект з пулу,
    //   працювати з ним і в кінці кінців закривати / віддавати назад в пул.

    public static synchronized ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                Context ctx = new InitialContext();
                DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/StudentsDS");
                con = dataSource.getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    //for query data
    public List getAllGroups() throws SQLException {
        List groups = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM academic_group");
        while (rs.next()) {
            AcademicGroup group = new AcademicGroup();
            group.setGroupId(rs.getInt(AcademicGroupEntry.ID));
            group.setTitle(rs.getString(AcademicGroupEntry.COL_TITLE));
            group.setMentor(rs.getInt(AcademicGroupEntry.COL_MENTOR_ID));
            groups.add(group);
        }
        rs.close();
        stmt.close();
        return groups;
    }

   /* public Collection getAllStudents() throws SQLException {
        Collection students = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student ORDER BY last_name, first_name");
        while (rs.next()) {
            Student student = new Student(rs);
            students.add(student);
        }
        rs.close();
        stmt.close();
        return students;
    }*/

    public Collection query(String uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        Collection result = new ArrayList();
        PreparedStatement stmt;
        String sql;
        ResultSet rs;
        switch (tableMatcher(uri)) {
            case STUDENT:
                sql = SQLUtils.buildSqlQuery(SQLContract.StudentsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Student st = new Student(rs);
                    result.add(st);
                }
                rs.close();
                stmt.close();
                break;
            case MENTOR:
                sql = SQLUtils.buildSqlQuery(SQLContract.MentorsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = con.prepareStatement(sql);
                 rs = stmt.executeQuery();
                while (rs.next()) {
                    Mentor st = new Mentor(rs);
                    result.add(st);
                }
                rs.close();
                stmt.close();
                break;
            case GROUP:
                sql = SQLUtils.buildSqlQuery(SQLContract.AcademicGroupEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    AcademicGroup st = new AcademicGroup(rs);
                    result.add(st);
                }
                rs.close();
                stmt.close();
                break;
        }
        return result;
    }

    public Collection getAllMentors() throws SQLException {
        Collection mentors = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mentor ORDER BY last_name, first_name");
        while (rs.next()) {
            Mentor mentor = new Mentor(rs);
             mentors.add(mentor);
        }
        rs.close();
        stmt.close();
        return mentors;
    }

    public Student getStudentById(int studentId) throws SQLException {
        Student student = null;
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            student = new Student(rs);
        }
        rs.close();
        stmt.close();
        return student;
    }

    public Mentor getMentorById(int mentorId) throws SQLException {
        Mentor mentor = null;
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM mentor WHERE id = ?");
        stmt.setInt(1, mentorId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            mentor = new Mentor(rs);
        }
        rs.close();
        stmt.close();
        return mentor;
    }

    public AcademicGroup getGroupById(int groupId) throws SQLException {
        AcademicGroup group = null;
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM academic_group WHERE id = ?");
        stmt.setInt(1, groupId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            group = new AcademicGroup(rs);
        }
        rs.close();
        stmt.close();
        return group;
    }

    public void moveStudentToGroup( int newGroupId, int studentId)
            throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE student SET group_id =  ? "
                + "WHERE  id = ? ");
        stmt.setInt(1, newGroupId);
        stmt.setInt(2, studentId);
        stmt.execute();
    }


    //for inserting data
    public void insertStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO student "
                + "(first_name, last_name, birth_day, group_id, book_number)"
                + "VALUES( ?,  ?,  ?,  ?,  ?)");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setDate(3, Date.valueOf((student.getDateOfBirthdy().toString("yyyy-MM-dd"))));
        stmt.setInt(4, student.getGroupId());
        stmt.setLong(5, student.getTestBookNumber());
        stmt.execute();
    }

    public void insertMentor(Mentor mentor) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO mentor "
                + "(first_name, last_name, group_id)"
                + "VALUES( ?,  ?,  ?)");
        stmt.setString(1, mentor.getFirstName());
        stmt.setString(2, mentor.getLastName());
        stmt.setInt(3, mentor.getGroupId());
        stmt.execute();
    }

    public void insertGroup(AcademicGroup group) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO academic_group "
                + "(title, mentor_id )"
                + "VALUES( ?,  ?)");
        stmt.setString(1, group.getTitle());
        stmt.setInt(2, group.getMentor());
        stmt.execute();
    }
    //for update data
    public void updateStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE student "
                + "SET first_name=?,last_name=?, birth_day=?, group_id=?, book_number=? "
                + " WHERE id=?");
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setDate(3, Date.valueOf((student.getDateOfBirthdy().toString("yyyy-MM-dd"))));
        stmt.setInt(4, student.getGroupId());
        stmt.setLong(5, student.getTestBookNumber());
        stmt.setInt(6, student.getStudentId());
        stmt.execute();
    }

    public void updateMentor(Mentor mentor) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE mentor "
                + "SET first_name=?,  last_name=?,  group_id=?"
                + " WHERE id=?");
        stmt.setString(1, mentor.getFirstName());
        stmt.setString(2, mentor.getLastName());
        stmt.setInt(3, mentor.getGroupId());
        stmt.setInt(4, mentor.getId());
        stmt.execute();
    }

    public void updateGroup(AcademicGroup group) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE academic_group "
                + "SET title=?,  mentor_id=?"
                + " WHERE id=?");
        stmt.setString(1, group.getTitle());
        stmt.setInt(2, group.getMentor());
        stmt.setInt(3, group.getGroupId());
        stmt.execute();
    }
    //for delete data
    public void deleteStudent(Student student) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE id =  ?");
        stmt.setInt(1, student.getStudentId());
        stmt.execute();
    }

    public void deleteMentor(Mentor mentor) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM mentor WHERE id =  ?");
        stmt.setInt(1, mentor.getId());
        stmt.execute();
    }

    public void deleteGroup(AcademicGroup group) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM academic_group WHERE id =  ?");
        stmt.setInt(1, group.getGroupId());
        stmt.execute();
    }

}
