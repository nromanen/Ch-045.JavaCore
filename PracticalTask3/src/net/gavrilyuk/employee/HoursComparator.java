package net.gavrilyuk.employee;

import java.util.Comparator;

/**
 * Hours Comparator Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class HoursComparator implements Comparator<Employee> {

    private int sortMode = 1;//sort mode

    public HoursComparator(boolean isDesc) {
        if (isDesc) sortMode =-1;
    }

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return sortMode * Long.compare(employee1.getHours(), employee2.getHours());
    }
}
