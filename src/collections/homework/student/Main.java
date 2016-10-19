package collections.homework.student;

import java.util.Collections;

import static collections.homework.student.Facultet.printStudents;
import static util.Print.println;

/*
 * Write class Student that provides information about the name of the student and his course.
 * Class Student should consists:
 * of properties for access to these fields
 * constructor with parameters
 * method printStudents (List students, Integer course), which receives a list of students and the course number
 * and prints to the console the names of the students from the list, which are taught in this course (use an iterator)
 * methods to compare students by name and by course
 * In the main() method
 * declare List students and add to the list five different students
 * display the list of students ordered by name
 * display the list of students ordered by course.
 */
public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Artem Petrov", 17, 1);
        Student student2 = new Student("Sacha Diachyna", 20, 3);
        Student student3 = new Student("Ivan Kaglan", 20, 3);
        Student student4 = new Student("Orest Obushak", 18, 1);
        Student student5 = new Student("Petro Saevich", 21, 4);
        Student student6 = new Student("Andriy Prybyla", 21, 5);
        Student student7 = new Student("Roman Rezin", 22, 5);
        Student student8 = new Student("Sacha Dudal", 20, 1);
        Student student9 = new Student("Ivan Ivanov", 19, 2);
        Student student10 = new Student("Evgen Petrenko", 18, 2);


        printStudents();

        Collections.sort(Facultet.students, StudentService.compareByName);

        println();
        printStudents();

        Collections.sort(Facultet.students, StudentService.getCompareByCourse);

        println();
        printStudents();

        println();

        printStudents(3);
    }

}
