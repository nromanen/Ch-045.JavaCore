package loopsandarrays.practice.employee;

import java.util.Collections;
import static util.Print.println;

 /*
  * Create a class Employee with fields name, department number, salary.
  * Create five objects of class Employee.
  * Display
  *     all employees of a certain department (enter department number in the console);
  *     arrange workers by the field salary in descending order.
  */

public class Main {

    public static void main (String[] args){

        Employee e1 = new Employee("Anton Popov", 1, 160);
        Employee e2 = new Employee("Denis Ivanov", 2, 90);
        Employee e3 = new Employee("Viktor Dudal", 1, 112);
        Employee e4 = new Employee("Ivan Markiv", 2, 123);
        Employee e5 = new Employee("Vitaliy Rinkin", 2, 100);
        Employee e6 = new Employee("Vasil Sorokin", 3, 200);

        EmploeeService.printAll();
        Collections.sort(Company.allEmployee, EmploeeService.compareBySalary);

        println();

        EmploeeService.printAll();

        Collections.sort(Company.allEmployee, EmploeeService.compareByName);

        println();

        EmploeeService.printAll();

        println();

        EmploeeService.printAll(1);



    }
}