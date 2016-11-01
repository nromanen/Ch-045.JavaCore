package students.web.forms;

import students.model.AcademicGroup;

import java.text.ParseException;
import java.util.Collection;

/**
 * MainFrameForm - show students with groups and filtering on name, testBookNum, etc..
 * Created by Igor Gavryliuk on 28.10.2016.
 */

public class MainFrameForm
{
    //filter fields
    private String bookNum;
    private String name;
    private int groupId;
    private int mentorId;
    //Collections fields
    private Collection groups;
    private Collection mentors;
    private Collection students;
    private String error;

    public void setBookNum(String bookNum) throws ParseException {
        this.bookNum = bookNum;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroups(Collection groups) {
        //add abstract group for filter in frame
        AcademicGroup group = new AcademicGroup();
        group.setGroupId(-1);
        group.setTitle("All");
        if (groups!=null) groups.add(group);
        this.groups = groups;
    }

    public Collection getGroups() {
        return groups;
    }

    public void setStudents(Collection students) {
        this.students = students;
    }

    public Collection getStudents() {
        return students;
    }

    public Collection getMentors() {
        return mentors;
    }

    public void setMentors(Collection mentors) {
        this.mentors = mentors;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
