package net.students.model;

import java.util.List;

/**
 * Academic Group
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class AcademicGroup {

    private int id;
    private String title;
    private Mentor mentor;
    private List<Student> studentsList;

    public AcademicGroup() {
    }

    public AcademicGroup(int id, String title, Mentor mentor) {
        this.id = id;
        this.title = title;
        this.mentor = mentor;
    }

    public AcademicGroup(int id, String title, Mentor mentor, List<Student> students) {
        this.id = id;
        this.title = title;
        this.mentor = mentor;
        this.studentsList = students;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addStudent(Student student) {
        return studentsList != null && student != null && studentsList.add(student);
    }

    public boolean removeStudent(Student student) {
        return studentsList != null && student != null && studentsList.remove(student);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) this.title = title;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        if (mentor!=null)  this.mentor = mentor;
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
        return  "Academic Group Id:" + id + "\n" +
                "Academic Group Title:" + title + "\n" +
                "Academic Group Mentor:" + mentor.toString() +"\n"+
                "Academic Group Students List:" +"\n"+ printStudentsList();
    }
}
