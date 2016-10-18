package net.gavtilyuk.task3;

import java.util.*;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class Students {

    private List<Student> students;

    public Students(List<Student> students) {
        this.students = students;
    }

    public Students() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortByCourse(boolean isDesc) {
        List<Student> result=  new ArrayList<>(students);
        if (!result.isEmpty()) {
            Collections.sort(result, new CourseComparator(isDesc));
        }
        return result;

    }

    public List<Student> sortByName(boolean isDesc) {
        List<Student> result=  new ArrayList<>(students);
        if (!result.isEmpty()) {
            Collections.sort(result,new NameComparator(isDesc) );
        }
        return result;

    }

    public List<String> printStudents(List studentsCourse, Integer course) {
        List<String> result = new ArrayList<>();
        if (studentsCourse != null && !studentsCourse.isEmpty()) {
            for(ListIterator it = studentsCourse.listIterator(); it.hasNext() ;)
            {
                //int i = it.nextIndex();
                Student s = (Student)it.next();
                if (s != null) {
                    if (s.getCourse() == course) result.add(s.getName());
                }

            }
        }


        return result;
    }
    //fill sample data students list
    public void fillList(int studentCount) {
        final String[] NAMES = new String[]{"Ihor","Jacob","Emily","Michael","David","Anna","Robert","Ihor","Thomas","Megan"};
        final int[] COURSES = new int[]{1, 2, 1, 2, 3, 4, 5, 3, 5, 2};
        if (students == null) students=new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student(NAMES[i],COURSES[i]));
        }
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
