package net.gavrilyuk.comparators;

import net.gavrilyuk.model.Student;

import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class DateComparator implements Comparator<Student> {
    private int mSortMode = 1;//sort mode

    public DateComparator(boolean isDesc) {
        if (isDesc) mSortMode =-1;
    }

    @Override
    public int compare(Student student1, Student student2) {
        return mSortMode * student1.getDateOfBirthdy().compareTo(student2.getDateOfBirthdy());
    }


}
