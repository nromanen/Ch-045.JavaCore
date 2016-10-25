package inheritance.homework.employee;

import java.util.ArrayList;
import java.util.List;

// department of company than contains employees
public class Department {

    private static int count = 1;
    private int id;

    private String name;

    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // Method add one employee in employee list
    public void addEmployee (Employee employee){
        if (!this.employeeList.contains(employee)){
            this.employeeList.add(employee);
        }
    }

    // Method add one and more  employees in employee list
    public void addEmployees(ArrayList<Employee> employees){
        for (Employee employee : employees) {
            if (!this.employeeList.contains(employee)){
                this.employeeList.add(employee);
            }
        }
    }

    // Method return avarage rate of all employee in department
    public double getAvarageWage(){
        double result = 0;

        for (Employee employee : employeeList) {
            result += employee.calculatePay();
        }
        return result/employeeList.size();
    }
}
