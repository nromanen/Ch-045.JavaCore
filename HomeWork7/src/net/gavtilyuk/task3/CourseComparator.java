package net.gavtilyuk.task3;

import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class CourseComparator implements Comparator<Student> {
    private int mSortMode = 1;//sort mode

    public CourseComparator(boolean isDesc) {
        if (isDesc) mSortMode =-1;
    }

    @Override
    public int compare(Student student1, Student student2) {
        return mSortMode * Long.compare(student1.getCourse(), student2.getCourse());
    }


}
