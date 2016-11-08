package net.students.model;

import org.joda.time.DateTime;

/**
 * Student Class
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Student extends Person  {

    private int studentId;
    private DateTime dateOfBirth;
    private int testBookNumber;
    private int groupId;

    public Student() {
    }

    public Student(int studentId, DateTime dateOfBirth, int testBookNumber, int groupId) {
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.testBookNumber = testBookNumber;
        this.groupId = groupId;
    }

    public Student(String firstName, String lastName, int studentId, DateTime dateOfBirth, int testBookNumber, int groupId) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.testBookNumber = testBookNumber;
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTestBookNumber() {
        return testBookNumber;
    }

    public void setTestBookNumber(int testBookNumber) {
        this.testBookNumber = testBookNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "studentId=" + studentId + ", " + super.toString() + ", dateOfBirth=" + getDateOfBirth().toString("yyyy-MM-dd")
                + ", testBookNumber=" + testBookNumber + ", groupId=" + groupId;
    }
}
