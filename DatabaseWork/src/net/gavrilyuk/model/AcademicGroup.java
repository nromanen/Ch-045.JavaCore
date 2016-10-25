package net.gavrilyuk.model;

import net.gavrilyuk.comparators.BookNumberComparator;
import net.gavrilyuk.comparators.DateComparator;
import net.gavrilyuk.comparators.NameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Academic Group
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class AcademicGroup {

    private String title;
    private Mentor mentor;
    private List<Student> studentsList;

    public AcademicGroup(String title, Mentor mentor, List<Student> students) {
        this.title = title;
        this.mentor = mentor;
        this.studentsList = students;
    }

    public AcademicGroup(String title, Mentor mentor) {
        this(title, mentor, new ArrayList<>());
    }

    public AcademicGroup(String title) {
        this(title, null, new ArrayList<>());
    }

    public boolean addStudent(Student student) {
        return studentsList != null && student != null && studentsList.add(student);
    }

    public boolean removeStudent(Student student) {
        return studentsList != null && student != null && studentsList.remove(student);
    }

   public List<Student> sortStudentsByName(boolean isDesc) {
       List<Student> sortedList = new ArrayList<>(studentsList);
       Collections.sort(sortedList,new NameComparator(isDesc));
       return  sortedList;
   }

    public List<Student> sortStudentsByDate(boolean isDesc) {
        List<Student> sortedList = new ArrayList<>(studentsList);
        Collections.sort(sortedList,new DateComparator(isDesc));
        return  sortedList;
    }

    public List<Student> sortStudentsByBooks(boolean isDesc) {
        List<Student> sortedList = new ArrayList<>(studentsList);
        Collections.sort(sortedList,new BookNumberComparator(isDesc));
        return  sortedList;
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
        return
                "Academic Group Title:" + title + "\n" +
                "Mentor:" + mentor.toString() +"\n"+
                "StudentsList:" +"\n"+ printStudentsList();
    }
}
