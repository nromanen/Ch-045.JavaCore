package net.gavrilyuk.employee;

import java.util.Comparator;

/**
 * Salary Comparator Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class SalaryComparator implements Comparator<Employee> {

    private int mSortMode = 1;//sort mode

    public SalaryComparator(boolean isDesc) {
        if (isDesc) mSortMode =-1;
    }

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return mSortMode * Float.compare(employee1.getSalary(), employee2.getSalary());
    }
}
