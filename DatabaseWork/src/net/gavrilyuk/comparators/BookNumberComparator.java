package net.gavrilyuk.comparators;

import net.gavrilyuk.model.Student;

import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class BookNumberComparator implements Comparator<Student> {
    private int mSortMode = 1;//sort mode

    public BookNumberComparator(boolean isDesc) {
        if (isDesc) mSortMode =-1;
    }

    @Override
    public int compare(Student student1, Student student2) {
        return mSortMode * Long.compare(student1.getTestBookNumber(), student2.getTestBookNumber());
    }


}
