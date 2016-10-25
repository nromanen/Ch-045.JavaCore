package net.gavrilyuk.comparators;

import net.gavrilyuk.model.Student;

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
        String name1 = s1.getFullName();
        String name2 = s2.getFullName();
        return isDesc ? name2.compareTo(name1) : name1.compareToIgnoreCase(name2);


    }
}
