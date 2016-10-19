package collections.homework.student;

import java.util.Comparator;


public class StudentService {

    // Compare students by name
    public static Comparator<Student> compareByName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    };

    // Compare students by course
    public static Comparator<Student> getCompareByCourse = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getCourse() > o2.getCourse()){
                return 1;
            } else if (o1.getCourse() == o2.getCourse()){
                return 0;
            } else {
                return -1;
            }
        }
    };
}
