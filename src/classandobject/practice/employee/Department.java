package classandobject.practice.employee;

import java.util.ArrayList;

import java.util.Collections;

public class Department {

    // List of all employee in the department
    public static ArrayList<Employee> allEmployee = new ArrayList<>();

    // Method return total sum of hours of all employee
    public static int totalSum(){
        int result = 0;
        for (Employee employee : allEmployee){
            result += employee.getHours();
        }
        return result;
    }

    // Method calculate bonuses 10% to the salary for 5 better(have the best hours) employee
    public static void bonus(){
        Collections.sort(allEmployee, EmploeeService.compareByHour);

        for(int i = 0; i < 5; i++){
            allEmployee.get(i).setSalary((int)(allEmployee.get(i).getSalary() * 1.1));
        }
    }

}
