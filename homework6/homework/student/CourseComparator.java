package homework6.homework.student;

import java.util.Comparator;

/**
 * Created by roma on 19.10.2016.
 */
public class CourseComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        Integer course1 = s1.getCourse();
        Integer course2 = s2.getCourse();
        if(course1 > course2){
            return 1;
        } else if (course1 == course2){
            return 0;
        } else {
            return -1;
        }
    }
}
