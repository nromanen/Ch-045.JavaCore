package net.students.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Academic Group
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class AcademicGroup {

    private int groupId;
    private String title;
    private int mentorId;
    private List<Student> studentsList;

    public AcademicGroup() {
    }

    public AcademicGroup(String title, int mentorId) {
        this.title = title;
        this.mentorId = mentorId;
    }

    public AcademicGroup(int groupId, String title, int mentorId) {
        this(groupId, title, mentorId, new ArrayList<>());
    }

    public AcademicGroup(int groupId, String title, int mentorId, List<Student> students) {
        this.groupId = groupId;
        this.title = title;
        this.mentorId = mentorId;
        this.studentsList = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) this.title = title;
    }


    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        if (studentsList!=null) this.studentsList = studentsList;
    }

    private String printStudentsList() {
        StringBuilder builder = new StringBuilder();
        if (studentsList != null && !studentsList.isEmpty()) {
            for (Student student : studentsList) {
                builder.append(student.toString()).append("\n");
            }
        } else builder.append("Empty list");
        return builder.toString();
    }

    @Override
    public String toString() {
        return  "Academic Group Id:" + groupId + "\n" +
                "Academic Group Title:" + title + "\n" +
                "Academic Group Mentor Id:" + mentorId +"\n"+
                "Academic Group Students List:" +"\n"+ printStudentsList();
    }
}
