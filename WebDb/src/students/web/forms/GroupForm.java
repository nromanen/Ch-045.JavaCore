package students.web.forms;

import students.model.AcademicGroup;

import java.util.Collection;

/**
 *  Mentor Form Class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class GroupForm
{
    private int groupId;
    private String title;
    private int mentorId;
    private Collection mentors;

    public void initFromGroup(AcademicGroup group) {
        this.groupId = group.getGroupId();
        this.title = group.getTitle();
        this.mentorId = group.getMentor();
        this.groupId = group.getGroupId();

    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection getMentors() {
        return mentors;
    }

    public void setMentors(Collection mentors) {
        this.mentors = mentors;
    }
}
