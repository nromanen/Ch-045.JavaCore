package homework4.practical.employee;

import homework4.practical.employee.Employee;

/**
 * Created by roma on 10.10.2016.
 * Create a class Employee with fields name, department number, salary.
 * Create five objects of class Employee. Display
        * all employees of a certain department (enter department number in the console);
        * arrange workers by the field salary in descending order.

 */
public class MainEmployee {
    public static void main(String[] args){

        Employee employee = new Employee();

        Employee employee1 =  new Employee("Danco", 4, 1600);
        Employee employee2 =  new Employee("Ubr", 1, 2300);
        Employee employee3 =  new Employee("Google", 2, 1500);
        Employee employee4 =  new Employee("Java", 4, 1200);
        Employee employee5 =  new Employee("Hugo", 2, 1900);

        employee.addArrayList(employee1);
        employee.addArrayList(employee2);
        employee.addArrayList(employee3);
        employee.addArrayList(employee4);
        employee.addArrayList(employee5);

        System.out.println("List employees: \n");
        employee.output();

        employee.getEmployeeDep();
        employee.sortBySalary();

        System.out.println("\nList employees after sorting by salary: \n");
        employee.output();
    }
}

