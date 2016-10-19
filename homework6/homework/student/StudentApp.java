package homework6.homework.student;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by roma on 19.10.2016.
 * Write class Student that provides information about the name of the student and his course.
 * Class Student should consists of
        properties for access to these fields
        constructor with parameters
        method printStudents (List students, Integer course),
            which receives a list of students and the course number and prints to the console
            the names of the students from the list, which are taught in this course (use an iterator)

        methods to compare students by name and by course
        In the main() method
            declare List students and add to the list five different students
            display the list of students ordered by name
            display the list of students ordered by course.

 */
public class StudentApp {
    public static void main(String[] args){

        StudentUtil student = new StudentUtil();

        student.insertFields(5);
        //Out students list
        student.printList();

        int course = 3;
        System.out.println("Select student by course:");
        student.printStudents(student.getStudent(),course);

        System.out.println("Sorted student by name:");
        Collections.sort(student.getStudent(),new NameComparator());
        student.printList();

        System.out.println("Sorted student by course:");
        Collections.sort(student.getStudent(), new CourseComparator());
        student.printList();
    }
}
