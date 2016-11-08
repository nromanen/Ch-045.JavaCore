package net.students.model;

/**
 * Mentor Class
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Mentor extends Person {

    private int mentorId;


    public Mentor() {
    }

    public Mentor( String firstName, String lastName) {
        super(firstName, lastName);

    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "mentorId=" + mentorId  +super.toString();
    }

}
