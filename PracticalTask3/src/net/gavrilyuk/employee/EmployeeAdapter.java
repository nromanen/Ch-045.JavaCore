package net.gavrilyuk.employee;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Employee Adapter from
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeAdapter extends AbstractTableModel {

    private final static int COLUMN_COUNT = 5;
    private final static int BONUS_COUNT = 5;
    private final static String COLUMN_BONUS = "Bonus";
    private static final String COLUMN_SALARY = "Salary";

    private List<Employee> employees;

    public EmployeeAdapter() {
        employees = new ArrayList<>();//create empty
    }

    public List<Employee> getData() {
        return employees;
    }

    public void sortData() {
        // sort by hours DESC
        if (employees != null) {
        Collections.sort(employees, new HoursComparator(true));
        fireTableDataChanged();
        }
    }

    public void setData(List<Employee> employees) {
        if (employees != null) {
            this.employees = employees;
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
        return employees != null ? employees.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return employees.get(r).getName();
            case 1:
                return employees.get(r).getRate();
            case 2:
                return employees.get(r).getHours();
            case 3:
                return String.format("%,.2f", employees.get(r).salary());
            case 4:
                if (r < BONUS_COUNT) {//first 5 get bonus  record r 0...4
                    return String.format("%,.2f", employees.get(r).bonuses());
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
        if (employees != null && employees.size()>0 ) {
            for (Employee employee : employees) {
                result+=employee.getHours();
            }
        }

        return result;
    }


}
