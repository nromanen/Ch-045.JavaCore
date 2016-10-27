package net.gavrilyuk.model;

import net.gavrilyuk.exceptions.MentorException;

/**
 * Mentor
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Mentor {

    private String firstName;
    private String lastName;

    public Mentor(String firstName, String lastName) throws MentorException {
        if (firstName==null || firstName.isEmpty()) throw new MentorException(1,"first name should not be empty!");
        if (lastName==null || lastName.isEmpty()) throw new MentorException(1,"last name should not be empty!");
        if (!Utils.checkName(firstName, false)) throw new MentorException(2, "invalid symbols in first name!");
        if (!Utils.checkName(lastName, false)) throw new MentorException(2, "invalid symbols in last name!");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws MentorException{
        if (firstName==null || firstName.isEmpty()) throw new MentorException(1,"first name should not be empty!");
        if (!Utils.checkName(firstName, true)) throw new MentorException(2, "invalid symbols in first name!");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws MentorException {
        if (lastName==null || lastName.isEmpty()) throw new MentorException(1,"last name should not be empty!");
        if (!Utils.checkName(lastName, true)) throw new MentorException(2, "invalid symbols in last name!");
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Mentor{" +"firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' +'}';
    }
}
