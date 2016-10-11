package lesson2.employee;

import java.util.Collections;
import static util.Print.println;


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
