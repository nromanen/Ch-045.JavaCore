package collections.homework.student;

import java.util.ArrayList;
import java.util.List;

import static util.Print.println;

public class Facultet {

    public static List<Student> students = new ArrayList<>();

    // Method print Students in facultet. If no input parameters will be printed all strudents
    // if is input parameter will be print student of this course
    public static void printStudents(int... course){
        if (course.length == 0) {
            for (Student student : students) {
                println(student);
            }
        } else {
            for (Student student : students) {
                if (student.getCourse() == course[0]) {
                    println(student);
                }
            }
        }
    }
}
