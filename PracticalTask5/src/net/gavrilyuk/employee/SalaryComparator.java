package net.gavrilyuk.employee;

import java.util.Comparator;

/**
 * Salary Comparator Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class SalaryComparator implements Comparator<NewEmployee> {

    private int sortMode = 1;//sort mode

    public SalaryComparator(boolean isDesc) {
        if (isDesc) sortMode =-1;
    }

    @Override
    public int compare(NewEmployee employee1, NewEmployee employee2) {
        return sortMode * Float.compare(employee1.getSalary(), employee2.getSalary());
    }
}
