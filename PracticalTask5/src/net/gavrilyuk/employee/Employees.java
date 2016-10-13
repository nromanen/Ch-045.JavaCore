package net.gavrilyuk.employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class Employees {

    private List<NewEmployee> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    public List<NewEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<NewEmployee> employees) {
        this.employees = employees;
    }

    public void addEmployee(NewEmployee employee) {
        if (employees !=null) employees.add(employee);
    }

    public void orderBySalary(boolean isDesc) {
        if (employees != null && employees.size() > 0) {
            Collections.sort(employees, new SalaryComparator(isDesc));
        }
    }

    //todo fix issue #8
    public List<NewEmployee> getEmpOnDepartment(int dep) {
        //StringBuilder result = new StringBuilder();
        List<NewEmployee>  result= new ArrayList<>();
        if (employees != null) {
            for (NewEmployee employee : employees) {
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
        if (employees != null) {
            for (NewEmployee employee : employees) {
                res.append(employee.toString()).append("\n");
            }
        }
        return res.toString();
    }
}
