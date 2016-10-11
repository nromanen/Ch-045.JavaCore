package net.gavrilyuk.employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class Employees {

    private List<NewEmployee> mEmployees;

    public Employees() {
        mEmployees = new ArrayList<>();
    }

    public List<NewEmployee> getEmployees() {
        return mEmployees;
    }

    public void setEmployees(List<NewEmployee> employees) {
        mEmployees = employees;
    }

    public void addEmployee(NewEmployee employee) {
        if (mEmployees!=null) mEmployees.add(employee);
    }
    public void orderBySalary(boolean isDesc) {
        if (mEmployees != null && mEmployees.size() > 0) {
            Collections.sort(mEmployees, new SalaryComparator(isDesc));
        }

    }

    //todo fix issue #8
    public ArrayList<NewEmployee> getEmpOnDepartment(int dep) {
        //StringBuilder result = new StringBuilder();
        ArrayList<NewEmployee>  result= new ArrayList<>();
        if (mEmployees != null) {
            for (NewEmployee employee : mEmployees) {
                if (employee.getDepNumber() == dep) {
                    //result.append(employee.toString()).append("\n");
                    result.add(employee);
                }
            }
        }
        /*if (result.length() == 0) {
            result.append("No employees in the department ").append(dep);
        }
        return result.toString();*/
        return result;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (mEmployees != null) {
            for (NewEmployee employee : mEmployees) {
                res.append(employee.toString()).append("\n");
            }
        }
        return res.toString();
    }
}
