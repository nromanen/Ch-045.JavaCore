package net.students.model;

import org.joda.time.DateTime;

/**
 * Student Class
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Student extends Person {

    private DateTime dateOfBirthdy;
    private int testBookNumber;

    public Student() {
        super();
    }

    public Student(int id, String firstName, String lastName, DateTime dateOfBirthdy, int testBookNumber) {
        super(id, firstName, lastName);
        this.dateOfBirthdy = dateOfBirthdy;
        this.testBookNumber = testBookNumber;
    }

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }


    public DateTime getDateOfBirthdy() {
        return dateOfBirthdy;
    }

    public void setDateOfBirthdy(DateTime dateOfBirthdy) {
        this.dateOfBirthdy = dateOfBirthdy;
    }

    public int getTestBookNumber() {
        return testBookNumber;
    }

    public void setTestBookNumber(int testBookNumber) {
        this.testBookNumber = testBookNumber;
    }

    @Override
    public String toString() {
        return super.toString()+", dateOfBirthdy=" + getDateOfBirthdy().toString("yyyy-MM-dd") +", testBookNumber=" + testBookNumber;
    }
}
