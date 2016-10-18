package net.gavtilyuk.task3;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */

        /*Write class Student that provides information about the name of the student and his course.
         Class Student should consists of:
        a) properties for access to these fields
        b) constructor with parameters
        c) method printStudents (List students, Integer course), which receives a list of students
           and the course number and prints to the console the names of the students from the list,
           which are taught in this course (use an iterator)
        d) methods to compare students by name and by course
        e) In the main() method
        1. declare List students and add to the list five different students
        2. display the list of students ordered by name
        3. display the list of students ordered by course.*/

public class Task3App {

    public static void main(String[] args) {
        Students students = new Students();
        students.fillList(10);
        System.out.println(students);
        int course = 2;
        System.out.println("Students names of course "+course+":"+students.printStudents(students.getStudents(),course));
        System.out.println(students.sortByName(false));
        System.out.println(students.sortByCourse(false));
        //students.getStudents().get(0).setName("");
        //students.getStudents().get(0).setCourse(-8);
    }
}
