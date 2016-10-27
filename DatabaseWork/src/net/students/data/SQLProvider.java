package net.students.data;

import net.students.model.AcademicGroup;
import net.students.model.Mentor;
import net.students.model.Student;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import net.students.data.SQLContract.StudentsEntry;
import net.students.data.SQLContract.MentorsEntry;
import net.students.data.SQLContract.AcademicGroupEntry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * Created by Igor Gavryliuk on 27.10.2016.
 */
public class SQLProvider {

    private static final Logger LOGGER = Logger.getLogger(SQLProvider.class.getName());

    private static SQLProvider contentProvider;
    private SQLOpenHelper sqlOpenHelper;

    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");


    private SQLProvider() throws SQLException, ClassNotFoundException {
        sqlOpenHelper = new SQLOpenHelper(SQLConnection.getConnection());
    }

    public static SQLProvider getInstance() throws SQLException, ClassNotFoundException {
        if (contentProvider == null) {
            contentProvider = new SQLProvider();
        }
        return contentProvider;
    }

    public SQLOpenHelper getSqlOpenHelper() {
        return sqlOpenHelper;
    }

     //todo release  GROUP BY, HAVING, LIMIT, ORDER BY
    public ArrayList<Student> getStudents(boolean distinct) throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT "+(distinct?"":"DISTINCT ")+" * FROM "+ StudentsEntry.TABLE_NAME);
        ArrayList<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            //Retrieve by column name
            Student student = new Student(
                    resultSet.getInt(StudentsEntry.ID),
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME),
                    resultSet.getString(StudentsEntry.COL_LAST_NAME),
                    fmt.parseDateTime(resultSet.getDate(StudentsEntry.COL_BIRTH_DAY).toString()),
                    resultSet.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setGroupId(resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            //log values
            LOGGER.info("student id: " + resultSet.getInt(StudentsEntry.ID) + " name=" +
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME) + " " + resultSet.getString(StudentsEntry.COL_LAST_NAME));
            result.add(student);
        }
        resultSet.close();
        return result;
    }

    public Student getStudentsWithId(int queryId) throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT * FROM " + StudentsEntry.TABLE_NAME + " WHERE id=" + queryId);
        Student student = null;
        if (resultSet.next()) {
            student = new Student(
                    resultSet.getInt(StudentsEntry.ID),
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME),
                    resultSet.getString(StudentsEntry.COL_LAST_NAME),
                    fmt.parseDateTime(resultSet.getDate(StudentsEntry.COL_BIRTH_DAY).toString()),
                    resultSet.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setGroupId(resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            //log values
            LOGGER.info("student id: " + resultSet.getInt(StudentsEntry.ID) + " name=" +
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME) + " " + resultSet.getString(StudentsEntry.COL_LAST_NAME));
        }
        resultSet.close();
        return student;
    }

    public List<Student> getStudentsWithGroupId(int groupId) throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT * FROM " + StudentsEntry.TABLE_NAME +
                " WHERE " + StudentsEntry.COL_GROUP_ID + " = " + groupId);
        ArrayList<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt(StudentsEntry.ID),
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME),
                    resultSet.getString(StudentsEntry.COL_LAST_NAME),
                    fmt.parseDateTime(resultSet.getDate(StudentsEntry.COL_BIRTH_DAY).toString()),
                    resultSet.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setGroupId(resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            //log values
            LOGGER.info("student id: " + resultSet.getInt(StudentsEntry.ID) + " name=" +
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME) + " " + resultSet.getString(StudentsEntry.COL_LAST_NAME)+
            "groupId="+resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            result.add(student);
        }
        resultSet.close();
        return result;
    }

    public List<Student> getStudentsWithLastName(String name) throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT * FROM " + StudentsEntry.TABLE_NAME +
                " WHERE " + StudentsEntry.COL_LAST_NAME + " LIKE '%" + name+"'%");
        ArrayList<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt(StudentsEntry.ID),
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME),
                    resultSet.getString(StudentsEntry.COL_LAST_NAME),
                    fmt.parseDateTime(resultSet.getDate(StudentsEntry.COL_BIRTH_DAY).toString()),
                    resultSet.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setGroupId(resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            //log values
            LOGGER.info("student id: " + resultSet.getInt(StudentsEntry.ID) + " name=" +
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME) + " " + resultSet.getString(StudentsEntry.COL_LAST_NAME)+
                    "groupId="+resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            result.add(student);
        }
        resultSet.close();
        return result;
    }

    public List<Student> orderStudentsBy(String column, boolean isDesc) throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT * FROM " + StudentsEntry.TABLE_NAME +
                " ORDER BY " + column + (isDesc ? " DESC " : ""));
        ArrayList<Student> result = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt(StudentsEntry.ID),
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME),
                    resultSet.getString(StudentsEntry.COL_LAST_NAME),
                    fmt.parseDateTime(resultSet.getDate(StudentsEntry.COL_BIRTH_DAY).toString()),
                    resultSet.getInt(StudentsEntry.COL_BOOK_NUM));
            student.setGroupId(resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            //log values
            LOGGER.info("student id: " + resultSet.getInt(StudentsEntry.ID) + " name=" +
                    resultSet.getString(StudentsEntry.COL_FIRST_NAME) + " " + resultSet.getString(StudentsEntry.COL_LAST_NAME) +
                    "groupId=" + resultSet.getInt(StudentsEntry.COL_GROUP_ID));
            result.add(student);
        }
        resultSet.close();
        return result;
    }


    public int insertStudent(Student student) throws SQLException {
        ContentValues cv = studentToContentValues(student);
        int rowsInserted = sqlOpenHelper.insert(StudentsEntry.TABLE_NAME, null, cv);
        if ( rowsInserted< 0 )
            throw new SQLException("Failed to insert row into " + StudentsEntry.TABLE_NAME);
        return rowsInserted;
    }

    public int removeStudent(int id) throws SQLException {
        return sqlOpenHelper.delete(StudentsEntry.TABLE_NAME, StudentsEntry.ID + " =? ", new String[]{String.valueOf(id)});
    }

    public int updateStudent(Student student) throws SQLException {
        ContentValues cv = studentToContentValues(student);
        return sqlOpenHelper.update(StudentsEntry.TABLE_NAME, cv,
                StudentsEntry.ID + " =? ", new String[]{String.valueOf(student.getId())});
    }

    public ArrayList<AcademicGroup> getGroups() throws SQLException {
        ResultSet resultSet = sqlOpenHelper.query("SELECT  * FROM " + AcademicGroupEntry.TABLE_NAME +
                " INNER JOIN "+MentorsEntry.TABLE_NAME+" ON academic_group.mentor_id = mentor.id");
        ArrayList<AcademicGroup> result = new ArrayList<>();
        while (resultSet.next()) {
            //Retrieve by column name
            Mentor mentor = new Mentor();
            mentor.setId(resultSet.getInt(MentorsEntry.ID));
            mentor.setFirstName(resultSet.getString(MentorsEntry.COL_FIRST_NAME));
            mentor.setLastName(resultSet.getString(MentorsEntry.COL_LAST_NAME));
            AcademicGroup group = new AcademicGroup(
                    resultSet.getInt(AcademicGroupEntry.ID),
                    resultSet.getString(AcademicGroupEntry.COL_TITLE),
                    mentor);
            result.add(group);
        }
        resultSet.close();
        return result;
    }
    private ContentValues  studentToContentValues(Student student) {
        ContentValues cv = new ContentValues();
        cv.put(StudentsEntry.COL_FIRST_NAME,student.getFirstName());
        cv.put(StudentsEntry.COL_LAST_NAME,student.getLastName());
        cv.put(StudentsEntry.COL_BIRTH_DAY, student.getDateOfBirthdy().toString("yyyy-MM-dd"));
        cv.put(StudentsEntry.COL_BOOK_NUM,student.getTestBookNumber());
        cv.put(StudentsEntry.COL_GROUP_ID, student.getGroupId());
        return cv;
    }

    private ContentValues  mentorToContentValues(Mentor mentor) {
        ContentValues cv = new ContentValues();
        cv.put(MentorsEntry.COL_FIRST_NAME, mentor.getFirstName());
        cv.put(MentorsEntry.COL_LAST_NAME, mentor.getLastName());
        return cv;
    }

    private ContentValues  groupToContentValues(AcademicGroup group) {
        ContentValues cv = new ContentValues();
        cv.put(AcademicGroupEntry.COL_TITLE,group.getTitle());
        cv.put(AcademicGroupEntry.COL_MENTOR_ID, group.getMentor().getId());
        return cv;
    }
}
