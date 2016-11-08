package net.students.controller;

/**
 *
 * Created by Igor Gavryliuk on 08.11.2016.
 */
public class StudentFilterForm {

    private String firstName;
    private String lastName;
    private String testBookNumber;
    private int groupId;

    public StudentFilterForm() {
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

    public String getTestBookNumber() {
        return testBookNumber;
    }

    public void setTestBookNumber(String testBookNumber) {
        this.testBookNumber = testBookNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
