package net.students.model;

/**
 * Person abstract class
 * Created by Igor Gavryliuk on 26.10.2016.
 */
public abstract class Person {

    private int id;
    private String firstName;
    private String lastName;
    private int groupId;

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }


    @Override
    public String toString() {
        return "id=" + id +", firstName='" + firstName + '\'' +", lastName='" + lastName + '\'';
    }
}
