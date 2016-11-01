package students.web.forms;

import students.model.Student;

import java.util.Collection;

/**
 * Student Form class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class StudentForm
{

    private int studentId;
    private String firstName;
    private String lastName;
    private String dateOfBirthdy;
    private int groupId;
    private long testBookNumber;
    private Collection groups;

    public void initFromStudent(Student st) {
        this.studentId = st.getStudentId();
        this.firstName = st.getFirstName();
        this.lastName = st.getLastName();
        this.dateOfBirthdy = st.getDateOfBirthdy().toString("yyyy-MM-dd");
        this.groupId = st.getGroupId();
        this.testBookNumber = st.getTestBookNumber();
    }

    public String getDateOfBirthdy() {
        return dateOfBirthdy;
    }

    public void setDateOfBirthdy(String dateOfBirthdy) {
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

    public void setGroups(Collection groups) {
        this.groups = groups;
    }

    public Collection getGroups() {
        return groups;
    }

}
