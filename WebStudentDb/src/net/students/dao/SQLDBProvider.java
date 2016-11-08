package net.students.dao;

import net.students.dao.SQLContract.AcademicGroupEntry;
import net.students.dao.SQLContract.MentorsEntry;
import net.students.dao.SQLContract.StudentsEntry;
import net.students.dao.SQLContract.UsersEntry;
import net.students.model.AcademicGroup;
import net.students.model.Mentor;
import net.students.model.Student;
import net.students.model.UserAccount;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL DB Provider class
 * Created by Igor Gavrilyuk on 06.11.2016.
 */
public class SQLDBProvider {

    public final int batchSize = 1000;

    private final Connection conn;
    private static SQLDBProvider provider;

    public SQLDBProvider() {
        conn = SQLDBConnection.getConnection();
    }

    public static SQLDBProvider getInstance() {
        if (provider == null) {
            provider = new SQLDBProvider();
        }
        return provider;
    }

    public  List<Student> queryStudents(String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        List<Student> result = new ArrayList<>();
        String sql = SQLUtils.buildSqlQuery(StudentsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
        PreparedStatement  stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while( rs.next() ) {
            Student student = new Student();
            student.setStudentId(rs.getInt(StudentsEntry.ID));
            student.setFirstName(rs.getString(StudentsEntry.COL_FIRST_NAME));
            student.setLastName(rs.getString(StudentsEntry.COL_LAST_NAME));
            student.setTestBookNumber(rs.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setDateOfBirth(DateTime.parse(rs.getDate(StudentsEntry.COL_BIRTH_DAY).toString()));
            student.setGroupId(rs.getInt(StudentsEntry.COL_GROUP_ID));
            result.add(student);
        }
        rs.close();
        stmt.close();
       return  result;
    }

    public  List<Mentor> queryMentors(String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        List<Mentor> result = new ArrayList<>();
        String sql = SQLUtils.buildSqlQuery(MentorsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
        PreparedStatement  stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while( rs.next() ) {
            Mentor mentor = new Mentor();
            mentor.setMentorId(rs.getInt(MentorsEntry.ID));
            mentor.setFirstName(rs.getString(MentorsEntry.COL_FIRST_NAME));
            mentor.setLastName(rs.getString(MentorsEntry.COL_LAST_NAME));
            result.add(mentor);
        }
        rs.close();
        stmt.close();
        return  result;
    }

    public  List<AcademicGroup> queryAcademicGroups(String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        List<AcademicGroup> result = new ArrayList<>();
        String sql = SQLUtils.buildSqlQuery(AcademicGroupEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
        PreparedStatement  stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while( rs.next() ) {
            AcademicGroup group = new AcademicGroup();
            group.setGroupId(rs.getInt(AcademicGroupEntry.ID));
            group.setTitle(rs.getString(AcademicGroupEntry.COL_TITLE));
            group.setMentorId(rs.getInt(AcademicGroupEntry.COL_MENTOR_ID));
            result.add(group);
        }
        rs.close();
        stmt.close();
        return  result;
    }

    public  List<UserAccount> queryUserAccounts(String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        List<UserAccount> result = new ArrayList<>();
        String sql = SQLUtils.buildSqlQuery(UsersEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
        PreparedStatement  stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while( rs.next() ) {
            UserAccount account = new UserAccount();
            account.setUserId(rs.getInt(UsersEntry.ID));
            account.setUserName(rs.getString(UsersEntry.COL_USER_NAME));
            account.setPassword(rs.getString(UsersEntry.COL_USER_PASS));
            result.add(account);
        }
        rs.close();
        stmt.close();
        return  result;
    }

    public int insertStudent(Student student) throws SQLException {
        int result;
        String query = "INSERT INTO " + StudentsEntry.TABLE_NAME +
                " (" + StudentsEntry.COL_FIRST_NAME + ", " + StudentsEntry.COL_LAST_NAME +
                ", " + StudentsEntry.COL_BOOK_NUM + ", " + StudentsEntry.COL_BIRTH_DAY + ", "
                + StudentsEntry.COL_GROUP_ID + ") VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, student.getFirstName());
        ps.setString(2, student.getLastName());
        ps.setInt(3, student.getTestBookNumber());
        ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
        ps.setInt(5, student.getGroupId());
        int inserted = ps.executeUpdate();
        ps.close();
        if (inserted > 0 ) result = inserted; else
            throw new SQLException("Failed to insert row into table "+StudentsEntry.TABLE_NAME);
        return result;
       }

    public int insertMentor(Mentor mentor) throws SQLException {
        int result;
        String query = "INSERT INTO " + MentorsEntry.TABLE_NAME +
                " (" + MentorsEntry.COL_FIRST_NAME + ", " + MentorsEntry.COL_LAST_NAME + ") VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, mentor.getFirstName());
        ps.setString(2, mentor.getLastName());
        int inserted = ps.executeUpdate();
        ps.close();
        if (inserted > 0 ) result = inserted; else
            throw new SQLException("Failed to insert row into table "+MentorsEntry.TABLE_NAME);
        return result;
    }

    public int insertAcademicGroup(AcademicGroup group) throws SQLException {
        int result;
        String query = "INSERT INTO " + AcademicGroupEntry.TABLE_NAME +
                " (" + AcademicGroupEntry.COL_TITLE + ", " + AcademicGroupEntry.COL_MENTOR_ID + ") VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, group.getTitle());
        ps.setInt(2, group.getMentorId());
        int inserted = ps.executeUpdate();
        ps.close();
        if (inserted > 0 ) result = inserted; else
            throw new SQLException("Failed to insert row into table "+AcademicGroupEntry.TABLE_NAME);
        return result;
    }

    public int insertUserAccount(UserAccount account) throws SQLException {
        int result;
        String query = "insert into "+UsersEntry.TABLE_NAME+" ("+UsersEntry.COL_USER_NAME+", "+UsersEntry.COL_USER_PASS+") values (?,?)";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, account.getUserName());
        ps.setString(2, account.getPassword());
        int inserted = ps.executeUpdate();
        ps.close();
        if (inserted > 0 ) result = inserted; else
            throw new SQLException("Failed to insert row into table "+UsersEntry.TABLE_NAME);
        return result;
    }

    public  int deleteStudent(int entityId) throws SQLException {
        int rowsDeleted;
        String query = "DELETE FROM " + StudentsEntry.TABLE_NAME + " WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, entityId);
        rowsDeleted = ps.executeUpdate();
        ps.close();
        return rowsDeleted;
    }

    public  int deleteMentor(int entityId) throws SQLException {
        int rowsDeleted;
        String query = "DELETE FROM " + MentorsEntry.TABLE_NAME + " WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, entityId);
        rowsDeleted = ps.executeUpdate();
        ps.close();
        return rowsDeleted;
    }

    public  int deleteAcademicGroup(int entityId) throws SQLException {
        int rowsDeleted;
        String query = "DELETE FROM " + AcademicGroupEntry.TABLE_NAME + " WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, entityId);
        rowsDeleted = ps.executeUpdate();
        ps.close();
        return rowsDeleted;
    }

    public  int deleteUser(int entityId) throws SQLException {
        int rowsDeleted;
        String query = "DELETE FROM " + UsersEntry.TABLE_NAME + " WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, entityId);
        rowsDeleted = ps.executeUpdate();
        ps.close();
        return rowsDeleted;
    }

    public  int updateStudent(Student student) throws SQLException {
        int rowsUpdated;
        String query = "UPDATE " + StudentsEntry.TABLE_NAME +
                " SET " + StudentsEntry.COL_FIRST_NAME + "=?, " + StudentsEntry.COL_LAST_NAME +
                "=?, " + StudentsEntry.COL_BOOK_NUM + "=?, " + StudentsEntry.COL_BIRTH_DAY +
                "=? , " + StudentsEntry.COL_GROUP_ID + "=?" + " WHERE " + StudentsEntry.ID + "=?";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString( 1, student.getFirstName() );
        ps.setString( 2, student.getLastName() );
        ps.setInt(3, student.getTestBookNumber());
        ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
        ps.setInt(5, student.getGroupId());
        ps.setInt(6, student.getStudentId());//where id=?
        rowsUpdated = ps.executeUpdate();
        ps.close();
        return rowsUpdated;
    }

    public  int updateMentor(Mentor mentor) throws SQLException {
        int rowsUpdated;
        String query = "UPDATE " + MentorsEntry.TABLE_NAME +
                " SET " + MentorsEntry.COL_FIRST_NAME + "=?, " + MentorsEntry.COL_LAST_NAME +
                "=? WHERE " + MentorsEntry.ID + "=?";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, mentor.getFirstName());
        ps.setString(2, mentor.getLastName());
        ps.setInt(3, mentor.getMentorId());//where id=?
        rowsUpdated = ps.executeUpdate();
        ps.close();
        return rowsUpdated;
    }

    public  int updateAcademicGroup(AcademicGroup group) throws SQLException {
        int rowsUpdated;
        String query = "UPDATE " + AcademicGroupEntry.TABLE_NAME +
                " SET " + AcademicGroupEntry.COL_TITLE + "=? , " + AcademicGroupEntry.COL_MENTOR_ID
                + "=? WHERE " + AcademicGroupEntry.ID + "=?";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, group.getTitle());
        ps.setInt(2, group.getMentorId());
        ps.setInt(3, group.getGroupId());//where id=?
        rowsUpdated = ps.executeUpdate();
        ps.close();
        return rowsUpdated;
    }

    public  int updateUser(UserAccount account) throws SQLException {
        int rowsUpdated;
        String query = "UPDATE " + UsersEntry.TABLE_NAME + " SET " + UsersEntry.COL_USER_NAME +
                "=?, " + UsersEntry.COL_USER_PASS + "=? WHERE " + UsersEntry.ID + "=?";
        PreparedStatement ps = conn.prepareStatement( query );
        ps.setString(1, account.getUserName());
        ps.setString(2, account.getPassword());
        ps.setInt(3, account.getUserId());//where id=?
        rowsUpdated = ps.executeUpdate();
        ps.close();
        return rowsUpdated;
    }

    public  int bulkInsertStudents( List<Student> students) throws SQLException {
        int result = 0;

        int count = 0;
        String query = "INSERT INTO " + StudentsEntry.TABLE_NAME +
                " (" + StudentsEntry.COL_FIRST_NAME + ", " + StudentsEntry.COL_LAST_NAME +
                ", " + StudentsEntry.COL_BOOK_NUM + ", " + StudentsEntry.COL_BIRTH_DAY + ", "
                + StudentsEntry.COL_GROUP_ID + ") VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        if (students != null && students.size() > 0) {
            for (Student student : students) {
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastName());
                ps.setInt(3, student.getTestBookNumber());
                ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
                ps.setInt(5, student.getGroupId());
                ps.addBatch();
                if (++count % batchSize == 0) {//don't OutOfMemoryError
                    ps.executeBatch();
                }
            }
            int[] insertedRows = ps.executeBatch();
            ps.close();
            int insertRowCount = 0;
            for (int i : insertedRows) {
                insertRowCount += i;
            }
            if (insertRowCount != students.size()) {
                System.out.println("Warning " + (students.size() - insertRowCount) + " records not inserted");
            }
            result = count;
        }
        return result;
    }

  public void close() {
      if (conn != null) {
          SQLDBConnection.closeConnection(conn);
      }
  }
}
