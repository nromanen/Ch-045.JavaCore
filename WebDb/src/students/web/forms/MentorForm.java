package students.web.forms;

import students.model.Mentor;

import java.util.Collection;

/**
 * Student Form class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class MentorForm
{

    private int mentorId;
    private String firstName;
    private String lastName;
    private int groupId;
    private Collection groups;

    public void initFromMentor(Mentor mentor) {
        this.mentorId = mentor.getId();
        this.firstName = mentor.getFirstName();
        this.lastName = mentor.getLastName();
        this.groupId = mentor.getGroupId();
        //System.out.println("Call initFromMentor mentorId="+mentor.getId());
    }

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Collection getGroups() {
        return groups;
    }

    public void setGroups(Collection groups) {
        this.groups = groups;
    }
}
