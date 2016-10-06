package lesson2.student;

import static util.Print.println;

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

        println(student1.betterStudent(student3));

        println(Student.avrRating);

        student1.changeRating(4.0);

        println(Student.avrRating);
    }
}
