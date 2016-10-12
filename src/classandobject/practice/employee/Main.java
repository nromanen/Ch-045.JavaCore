package classandobject.practice.employee;

import java.util.Collections;
import static util.Print.println;
 /*
 *Create Console Application project in Java.
 * Add class Employee to the project.
 * Class Employee should consists of
 *      three private fields: name, rate and hours;
 *      static field totalSum
 *      properties for access to these fields;
 *      default constructor, constructor with 2 parameters (name and rate) and constructor with 3 parameters;
 * methods:
 *      salary - to calculate the salary of person (rate * hours)
 *      toString - to output information about employee
 *      changeRate - to change the rate of employee
 *      bonuses – to calculate 10% from salary
 * In the method main() create 3 objects of Employee type. Input information about them.
 * Display the total hours of all workers to screen
  */

public class Main {

    public static void main (String[] args){

        Employee e1 = new Employee("Anton Popov", 54, 160);
        Employee e2 = new Employee("Denis Ivanov", 43, 90);
        Employee e3 = new Employee("Viktor Dudal", 76, 112);
        Employee e4 = new Employee("Ivan Markiv", 55, 123);
        Employee e5 = new Employee("Vitaliy Rinkin", 54, 100);
        Employee e6 = new Employee("Vasil Sorokin", 40, 200);

        Collections.sort(Department.allEmployee, EmploeeService.compareByHour);

        EmploeeService.printAll();

        Department.bonus();

        println();

        EmploeeService.printAll();

        Collections.sort(Department.allEmployee, EmploeeService.compareBySalary);

        println();

        EmploeeService.printAll();

        println("Total hours are " + Department.totalSum());
    }
}
