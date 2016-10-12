package classandobject.practice.student;

import java.util.ArrayList;
import java.util.List;

public class Group {

    //list of all students in the group
    public static List<Student> students = new ArrayList<>();

    // Method return average rating of group
    public static double avrRating(){

        double avrRating = 0.0;
        for (Student student: students){
            avrRating += student.getRating();
        }

        return avrRating/students.size();
    }

    public static double totalRating(){

        double totalRating = 0.0;
        for (Student student: students){
            totalRating += student.getRating();
        }

        return totalRating;
    }
}
