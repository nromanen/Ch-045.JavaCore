package net.gavtilyuk.task3;

import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class NameComparator implements Comparator<Student> {

    private boolean isDesc;//sort mode

    public NameComparator(boolean isDesc) {
        this.isDesc = isDesc;
    }

    @Override
    public int compare(Student s1, Student s2) {
        String name1 = s1.getName();
        String name2 = s2.getName();
        //ascending order
        //return StudentName1.compareToIgnoreCase(name2);
        //descending order
        //return name2.compareTo(StudentName1);
        return isDesc ? name2.compareTo(name1) : name1.compareToIgnoreCase(name2);


    }
}
