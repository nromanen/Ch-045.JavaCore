package classandobject.practice.student;

import static util.Print.println;

 /*
 *Create Console Application project in Java.
 * Add class Student to the project.
 * Class Student should consists of two private fields: name and rating;
 * properties for access to these fields
 * static field avgRating – average rating of all students
 * default constructor and constructor with parameters
 * methods:
 *      betterStudent - to definite the better student (between two, return true or false)
 *      toString - to output information about student
 *      changeRating - to change the rating of student
 * In the method main() create 3 objects of Student type and input information about them.
 * Display the average and total rating of all student
 */

public class Main {

    public static void main (String ... arg){

        Student student1 = new Student("Andrew", 4.6);
        Student student2 = new Student("Tom", 3.2);
        Student student3 = new Student("John", 5.0);
        Student student4 = new Student("Mike");

        println(student1);
        println(student2);
        println(student3);
        println(student4);

        println("The student ", student3.getName()," is ",  (student3.betterStudent(student1)? "better": "worse"), " than the student ", student1.getName(), ".");

        println("The average rating of the group is ",Group.avrRating(), ".");

        student4.changeRating(4.0);

        println("The average rating of the group is ", Group.avrRating(), ".");

        println("The total rating of the group is ",Group.totalRating(), ".");
    }
}
