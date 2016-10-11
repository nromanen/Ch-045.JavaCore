package lesson3.employee;

import java.util.Collections;
import static util.Print.println;


public class Main {

    public static void main (String[] args){

        Employee e1 = new Employee("Anton Popov", 1, 160);
        Employee e2 = new Employee("Denis Ivanov", 2, 90);
        Employee e3 = new Employee("Viktor Dudal", 1, 112);
        Employee e4 = new Employee("Ivan Markiv", 2, 123);
        Employee e5 = new Employee("Vitaliy Rinkin", 2, 100);
        Employee e6 = new Employee("Vasil Sorokin", 3, 200);

        EmploeeService.printAll();
        Collections.sort(Department.allEmployee, EmploeeService.compareBySalary);

        println();

        EmploeeService.printAll();

        Collections.sort(Department.allEmployee, EmploeeService.compareByName);

        println();

        EmploeeService.printAll();

        println();

        EmploeeService.printAll(1);



    }
}
