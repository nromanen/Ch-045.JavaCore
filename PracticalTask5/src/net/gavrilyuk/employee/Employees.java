package net.gavrilyuk.employee;


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class Employees {

    private ArrayList<Employee> mEmployees;

    public Employees() {
        mEmployees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return mEmployees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        mEmployees = employees;
    }

    public void addEmployee(Employee employee) {
        if (mEmployees!=null) mEmployees.add(employee);
    }
    public void orderBySalary(boolean isDesc) {
        if (mEmployees != null && mEmployees.size() > 0) {
            Collections.sort(mEmployees, new SalaryComparator(isDesc));
        }

    }

    public String getEmpOnDepartment(int dep) {
        StringBuilder result = new StringBuilder();
        if (mEmployees != null) {
            for (Employee employee : mEmployees) {
                if (employee.getDepNumber() == dep) {
                    result.append(employee.toString()).append("\n");
                }
            }
        }
        if (result.length() == 0) {
            result.append("No employees in the department ").append(dep);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (mEmployees != null) {
            for (Employee employee : mEmployees) {
                res.append(employee.toString()).append("\n");
            }
        }
        return res.toString();
    }
}
