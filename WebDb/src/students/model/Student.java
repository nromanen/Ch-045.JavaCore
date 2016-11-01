package students.model;

import org.joda.time.DateTime;
import students.logic.SQLContract.StudentsEntry;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

/**
 * Person abstract class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class Student implements Serializable
{
    private int studentId;
    private String firstName;
    private String lastName;
    private DateTime dateOfBirthdy;
    private int groupId;
    private long testBookNumber;
    private Object mGroups;


    public Student(ResultSet rs) throws SQLException {
        setStudentId(rs.getInt(StudentsEntry.ID));
        setFirstName(rs.getString(StudentsEntry.COL_FIRST_NAME));
        setLastName(rs.getString(StudentsEntry.COL_LAST_NAME));
        setDateOfBirthdy(DateTime.parse(rs.getDate(StudentsEntry.COL_BIRTH_DAY).toString()));
        setGroupId(rs.getInt(StudentsEntry.COL_GROUP_ID));
        setTestBookNumber(rs.getInt(StudentsEntry.COL_BOOK_NUM));
    }

    public Student() {
    }

    public DateTime getDateOfBirthdy() {
        return dateOfBirthdy;
    }

    public void setDateOfBirthdy(DateTime dateOfBirthdy) {
        this.dateOfBirthdy = dateOfBirthdy;
    }

    public long getTestBookNumber() {
        return testBookNumber;
    }

    public void setTestBookNumber(long testBookNumber) {
        this.testBookNumber = testBookNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return lastName + " " + firstName +  " "
                + DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirthdy)
                + " " + groupId + " " + testBookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        if (getStudentId() != student.getStudentId()) return false;
        if (getGroupId() != student.getGroupId()) return false;
        if (getTestBookNumber() != student.getTestBookNumber()) return false;
        if (getFirstName() != null ? !getFirstName().equals(student.getFirstName()) : student.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(student.getLastName()) : student.getLastName() != null)
            return false;
        return !(getDateOfBirthdy() != null ? !getDateOfBirthdy().equals(student.getDateOfBirthdy()) : student.getDateOfBirthdy() != null);

    }

    @Override
    public int hashCode() {
        int result = getStudentId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirthdy() != null ? getDateOfBirthdy().hashCode() : 0);
        result = 31 * result + getGroupId();
        result = (int) (31 * result + getTestBookNumber());
        return result;
    }

    public void setGroups(Object groups) {
        mGroups = groups;
    }

    public Object getGroups() {
        return mGroups;
    }
}
