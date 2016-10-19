package net.gavtilyuk.task3;

import java.util.*;

/**
 * Students Service Class
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class StudentsService {

    private List<Student> students;

    public StudentsService(List<Student> students) {
        this.students = students;
    }

    public StudentsService() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // ordered by course
    public List<Student> orderByCourse(boolean isDesc) {
        List<Student> result=  new ArrayList<>(students);
        if (!result.isEmpty()) {
            Collections.sort(result, new CourseComparator(isDesc));
        }
        return result;

    }
   // ordered by name
    public List<Student> orderByName(boolean isDesc) {
        List<Student> result=  new ArrayList<>(students);
        if (!result.isEmpty()) {
            Collections.sort(result,new NameComparator(isDesc) );
        }
        return result;

    }
    //which receives a list of students and the course number
    public List<String> printStudents(List studentsCourse, Integer course) throws StudentException {
        List<String> result = new ArrayList<>();
        if (course<0)  throw new StudentException(2, "course must be positive!");
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
    public void fillList(int studentCount) throws StudentException {
        final String[] NAMES = new String[]{"Ihor","Jacob","Emily","Michael","David","Anna","Robert","Ihor","Thomas","Megan"};
        final int[] COURSES = new int[]{1, 2, 1, 2, 3, 4, 5, 3, 5, 2};
        if (students == null) students=new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student(NAMES[i], COURSES[i]));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (students.isEmpty()) return builder.append("Empty list!").toString();
        for (Student student : students) {
            builder.append(student.toString());
        }
        return  builder.toString() ;
    }
}
