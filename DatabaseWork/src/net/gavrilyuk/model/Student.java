package net.gavrilyuk.model;

import net.gavrilyuk.exceptions.InvalidDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Student Class
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Student {

    private String firstName;
    private String lastName;
    private Date dateOfBirthdy;
    private int testBookNumber;

    public Student(String firstName, String lastName, Date dateOfBirthdy, int testBookNumber) throws InvalidDateException{
        if (dateOfBirthdy.after(new Date()))
            throw  new InvalidDateException(dateOfBirthdy,"Date of Birth can not be more than the current date");
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirthdy = dateOfBirthdy;
        this.testBookNumber = testBookNumber;
    }

    public Student(String firstName, String lastName, String dateOfBirthdy, int testBookNumber) throws ParseException {
        this(firstName,lastName,new SimpleDateFormat("dd.MM.yyyy ").parse(dateOfBirthdy),testBookNumber);
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

    public Date getDateOfBirthdy() {
        return dateOfBirthdy;
    }

    public void setDateOfBirthdy(Date dateOfBirthdy) {
        this.dateOfBirthdy = dateOfBirthdy;
    }

    public int getTestBookNumber() {
        return testBookNumber;
    }

    public void setTestBookNumber(int testBookNumber) {
        this.testBookNumber = testBookNumber;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirthdy=" + new SimpleDateFormat("dd.MM.yyyy ").format(getDateOfBirthdy()) +
                ", testBookNumber=" + testBookNumber +
                '}';
    }
}
