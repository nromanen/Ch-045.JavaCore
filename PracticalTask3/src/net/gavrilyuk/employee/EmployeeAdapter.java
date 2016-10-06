package net.gavrilyuk.employee;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Employee Adapter from
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeAdapter extends AbstractTableModel {

    private final static int COLUMN_COUNT = 5;
    private final static int BONUS_COUNT = 5;
    private final static String COLUMN_BONUS = "Bonus";
    private static final String COLUMN_SALARY = "Salary";

    private ArrayList<Employee> mEmployees;

    public EmployeeAdapter() {
        mEmployees = new ArrayList<>();//create empty
    }

    public ArrayList<Employee> getData() {
        return mEmployees;
    }

    public void sortData() {
        // sort by hours DESC
        Collections.sort(mEmployees, new HoursComparator(true));
        fireTableDataChanged();
    }

    public void setData(ArrayList<Employee> employees) {
        if (employees != null) {
            mEmployees = employees;
            sortData();
        }

    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
                EmployeeLab.get().addEmployee(employee);
                sortData();
        }
    }

    public void removeEmployee(int index) {
          EmployeeLab.get().removeEmployee(index);
          sortData();
    }

    @Override
    public int getRowCount() {
        return mEmployees != null ? mEmployees.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return mEmployees.get(r).getName();
            case 1:
                return mEmployees.get(r).getRate();
            case 2:
                return mEmployees.get(r).getHours();
            case 3:
                return String.format("%,.2f", mEmployees.get(r).salary());
            case 4:
                if (r < BONUS_COUNT) {//first 5 get bonus  record r 0...4
                    return String.format("%,.2f", mEmployees.get(r).bonuses());
                } else return 0;
            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return Employee.JSON_NAME;
            case 1:
                return Employee.JSON_RATE;
            case 2:
                return Employee.JSON_HOURS;
            case 3:
                return COLUMN_SALARY;
            case 4:
                return COLUMN_BONUS;
            default:
                return "Invalid Column";
        }
    }

    public long getTotalHours() {
        long result = 0;
        if (mEmployees != null && mEmployees.size()>0 ) {
            for (Employee employee : mEmployees) {
                result+=employee.getHours();
            }
        }

        return result;
    }


}
