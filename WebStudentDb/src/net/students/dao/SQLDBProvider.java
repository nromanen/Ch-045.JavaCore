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

    private static final int STUDENT = 100;
    private static final int MENTOR = 101;
    private static final int GROUP = 102;
    private static final int USER = 103;


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

    // TODO implement
    //To reduce the number of requests in database
    /* SELECT * FROM student s
                INNER JOIN academic_group a ON s.group_id = a.id
                INNER JOIN mentor m ON a.mentor_id = m.id;
    */

    @SuppressWarnings("unchecked")
    public <E> List<E> query(String table, String[] projection, String selection, String[] selectionArgs, String sortOrder) throws SQLException {
        List<E> result = new ArrayList<>();
        PreparedStatement stmt;
        String sql;
        ResultSet rs;
        switch (tableMatcher(table)) {
            case STUDENT:
                sql = SQLUtils.buildSqlQuery(StudentsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while( rs.next() ) {
                    Student student = new Student();
                    student.setStudentId(rs.getInt(StudentsEntry.ID));
                    student.setFirstName(rs.getString(StudentsEntry.COL_FIRST_NAME));
                    student.setLastName(rs.getString(StudentsEntry.COL_LAST_NAME));
                    student.setTestBookNumber(rs.getInt(StudentsEntry.COL_BOOK_NUM));
                    student.setDateOfBirth(DateTime.parse(rs.getDate(StudentsEntry.COL_BIRTH_DAY).toString()));
                    student.setGroupId(rs.getInt(StudentsEntry.COL_GROUP_ID));
                    result.add((E) student);
                }
                rs.close();
                stmt.close();
                break;
            case MENTOR:
                sql = SQLUtils.buildSqlQuery(MentorsEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while( rs.next() ) {
                    Mentor mentor = new Mentor();
                    mentor.setMentorId(rs.getInt(MentorsEntry.ID));
                    mentor.setFirstName(rs.getString(MentorsEntry.COL_FIRST_NAME));
                    mentor.setLastName(rs.getString(MentorsEntry.COL_LAST_NAME));
                    result.add((E)mentor);
                }
                rs.close();
                stmt.close();
                break;
            case GROUP:
                sql = SQLUtils.buildSqlQuery(AcademicGroupEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while( rs.next() ) {
                    AcademicGroup group = new AcademicGroup();
                    group.setGroupId(rs.getInt(AcademicGroupEntry.ID));
                    group.setTitle(rs.getString(AcademicGroupEntry.COL_TITLE));
                    group.setMentorId(rs.getInt(AcademicGroupEntry.COL_MENTOR_ID));
                    result.add((E)group);
                }
                rs.close();
                stmt.close();
                break;
            case USER:
                sql = SQLUtils.buildSqlQuery(UsersEntry.TABLE_NAME, projection, selection, selectionArgs, sortOrder);
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while( rs.next() ) {
                    UserAccount account = new UserAccount();
                    account.setUserId(rs.getInt(UsersEntry.ID));
                    account.setUserName(rs.getString(UsersEntry.COL_USER_NAME));
                    account.setPassword(rs.getString(UsersEntry.COL_USER_PASS));
                    result.add((E)account);
                }
                rs.close();
                stmt.close();
                break;
            default:
                throw new UnsupportedOperationException("Unknown table: " + table);
        }
        return result;
    }

    public <E> int insert(String table,  E entity) throws SQLException {
        int result;
        String query;
        PreparedStatement ps;
        switch (tableMatcher(table)) {
            case STUDENT: {
                Student student = (Student)entity;
                query = "insert into student (first_name, last_name,  book_number, birth_day, group_id) values (?,?,?,?,?)";
                ps = conn.prepareStatement( query );
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastName());
                ps.setInt(3, student.getTestBookNumber());
                ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
                ps.setInt(5, student.getGroupId());
                int inserted = ps.executeUpdate();
                ps.close();
                if (inserted > 0 ) result = inserted; else
                    throw new SQLException("Failed to insert row into " + table);
                break;
            }
            case MENTOR:{
                Mentor mentor = (Mentor)entity;
                query = "insert into mentor (first_name, last_name) values (?,?)";
                ps = conn.prepareStatement( query );
                ps.setString(1, mentor.getFirstName());
                ps.setString(2, mentor.getLastName());
                int inserted = ps.executeUpdate();
                ps.close();
                if (inserted > 0 ) result = inserted; else
                    throw new SQLException("Failed to insert row into " + table);
                break;
            }
            case GROUP:{
                AcademicGroup group = (AcademicGroup)entity;
                query = "insert into academic_group (title, mentor_id) values (?,?)";
                ps = conn.prepareStatement( query );
                ps.setString(1, group.getTitle());
                ps.setInt(2, group.getMentorId());
                int inserted = ps.executeUpdate();
                ps.close();
                if (inserted > 0 ) result = inserted; else
                    throw new SQLException("Failed to insert row into " + table);
                break;
            }
            case USER:{
                UserAccount account = (UserAccount) entity;
                query = "insert into "+UsersEntry.TABLE_NAME+" ("+UsersEntry.COL_USER_NAME+", "+UsersEntry.COL_USER_PASS+") values (?,?)";
                ps = conn.prepareStatement( query );
                ps.setString(1, account.getUserName());
                ps.setString(2, account.getPassword());
                int inserted = ps.executeUpdate();
                ps.close();
                if (inserted > 0 ) result = inserted; else
                    throw new SQLException("Failed to insert row into " + table);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown table: " + table);
        }
        return result;
    }

    public  int delete(String table, int entityId) throws SQLException {
        final int match = tableMatcher(table);
        PreparedStatement ps;
        String query;
        int rowsDeleted;
        switch (match) {
            case STUDENT:
                query = "delete from student where id=?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, entityId);
                rowsDeleted = ps.executeUpdate();
                ps.close();
                break;
            case MENTOR:
                query = "delete from mentor where id=?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, entityId);
                rowsDeleted = ps.executeUpdate();
                ps.close();
                break;
            case GROUP:
                query = "delete from academic_group where id=?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, entityId);
                rowsDeleted = ps.executeUpdate();
                ps.close();
                break;
            case USER:
                query = "delete from user_account where id=?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, entityId);
                rowsDeleted = ps.executeUpdate();
                ps.close();
                break;
            default:
                throw new UnsupportedOperationException("Unknown table: " + table);
        }
        return rowsDeleted;
    }

    public <E> int update(String table, E entity) throws SQLException {
        final int match = tableMatcher(table);
        PreparedStatement ps;
        String query;
        int rowsUpdated;
        switch (match) {
            case STUDENT:
                Student student = (Student) entity;
                query = "update student set first_name=?, last_name=?, book_number=?, birth_day=? ,group_id=? where id=?";
                ps = conn.prepareStatement( query );
                ps.setString( 1, student.getFirstName() );
                ps.setString( 2, student.getLastName() );
                ps.setInt(3, student.getTestBookNumber());
                ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
                ps.setInt(5, student.getGroupId());
                ps.setInt(6, student.getStudentId());//where id=?
                rowsUpdated = ps.executeUpdate();
                ps.close();
                break;
            case MENTOR:
                Mentor mentor = (Mentor) entity;
                query = "update mentor set first_name=?, last_name=? where id=?";
                ps = conn.prepareStatement( query );
                ps.setString(1, mentor.getFirstName());
                ps.setString(2, mentor.getLastName());
                ps.setInt(3, mentor.getMentorId());//where id=?
                rowsUpdated = ps.executeUpdate();
                ps.close();
                break;
            case GROUP:
                AcademicGroup group = (AcademicGroup) entity;
                query = "update academic_group set title=?, mentor_id=? where id=?";
                ps = conn.prepareStatement( query );
                ps.setString(1, group.getTitle());
                ps.setInt(2, group.getMentorId());
                ps.setInt(3, group.getGroupId());//where id=?
                rowsUpdated = ps.executeUpdate();
                ps.close();
                break;
            case USER:
                UserAccount account = (UserAccount) entity;
                query = "update user_account set USER_NAME=?, PASSWORD=? where id=?";
                ps = conn.prepareStatement( query );
                ps.setString(1, account.getUserName());
                ps.setString(2, account.getPassword());
                ps.setInt(3, account.getUserId());//where id=?
                rowsUpdated = ps.executeUpdate();
                ps.close();
                break;
            default:
                throw new UnsupportedOperationException("Unknown table: " + table);
        }
        return rowsUpdated;
    }


    public <E> int bulkInsert(String table, List<E> values) throws SQLException {
        int result;
        String query;
        PreparedStatement ps;
        final int batchSize = 1000;
        int count = 0;
        switch (tableMatcher(table)) {
            case STUDENT: {
                query = "INSERT INTO student (first_name, last_name,  book_number, birth_day, group_id) VALUES (?,?,?,?,?)";
                ps = conn.prepareStatement(query);
                if (values != null && values.size() > 0) {
                    for (E value : values) {
                        Student student = (Student) value;
                        ps.setString(1, student.getFirstName());
                        ps.setString(2, student.getLastName());
                        ps.setInt(3, student.getTestBookNumber());
                        ps.setDate(4, Date.valueOf((student.getDateOfBirth().toString("yyyy-MM-dd"))));
                        ps.setInt(5, student.getGroupId());
                        ps.addBatch();
                        if(++count % batchSize == 0) {//don't OutOfMemoryError
                            ps.executeBatch();
                        }
                    }
                    int[] insertedRows = ps.executeBatch();
                    ps.close();
                    int insertRowCount = 0;
                    for (int i : insertedRows) {
                        insertRowCount += i;
                    }
                    if (insertRowCount != values.size()) {
                        System.out.println("Warning "+(values.size()-insertRowCount)+" records not inserted");
                    }
                    result =count;
                    break;
                }
            }
            default:
                throw new UnsupportedOperationException("Unknown table: " + table);
        }
        return result;
    }

    private static int  tableMatcher(String table) {
        if (table.equalsIgnoreCase(StudentsEntry.TABLE_NAME)) {
            return STUDENT;
        }
        if (table.equalsIgnoreCase(MentorsEntry.TABLE_NAME)) {
            return MENTOR;
        }
        if (table.equalsIgnoreCase(AcademicGroupEntry.TABLE_NAME)) {
            return GROUP;
        }
        if (table.equalsIgnoreCase(UsersEntry.TABLE_NAME)) {
            return USER;
        }
        return -1;
    }

  public void close() {
      if (conn != null) {
          SQLDBConnection.closeConnection(conn);
      }
  }
}
