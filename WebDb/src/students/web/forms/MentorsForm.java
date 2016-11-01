package students.web.forms;

import java.util.Collection;

/**
 *  Mentor Form Class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class MentorsForm
{
    private int mentorId;
    private String firstName;
    private String lastName;
    private Collection groups;
    private Collection mentors;


    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
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

    public Collection getGroups() {
        return groups;
    }

    public void setGroups(Collection groups) {
        this.groups = groups;
    }

    public Collection getMentors() {
        return mentors;
    }

    public void setMentors(Collection mentors) {
        this.mentors = mentors;
    }


}
