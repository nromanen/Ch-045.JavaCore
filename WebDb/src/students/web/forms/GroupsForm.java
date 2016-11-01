package students.web.forms;

import java.util.Collection;

/**
 *  Mentor Form Class
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class GroupsForm
{
    private int groupId;
    private String title;
    private Collection mentors;
    private Collection groups;

    public int getGroupId() {
        return groupId;
    }

    public Collection getGroups() {
        return groups;
    }

    public void setGroups(Collection groups) {
        this.groups = groups;
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
