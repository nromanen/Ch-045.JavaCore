package inheritance.homework.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Print.println;

/* Create an interface to the method calculatePay(), the base class Employee with a string variable employeeld.
 * Create two classes SalariedEmployee and ContractEmployee,
 * which implement interface and are inherited from the base class.
 * Describe hourly paid workers in the relevant classes (one of the children), and fixed paid workers (second child).
 * Describe the string variable socialSecurityNumber in the class SalariedEmployee .
 * Include a description of federalTaxIdmember in the class of contractEmployee .
 * The calculation formula for the "time-worker“ is: "the average monthly salary = hourly rate * number of hours worked"
 * For employees with a fixed payment the formula is: "the average monthly salary = fixed monthly payment“
 * Create an array of employees and add the employees with different form of payment.
 * Arrange the entire sequence of workers descending the average monthly wage.
 * Output the employee ID, name, and the average monthly wage for all elements of the list.
 */
public class Main {

    public static void main(String[] args) {
        Department department1 = new Department("Development Department");

        department1.addEmployee(new SalariedEmployee("Ivan", Category.BEGINNER, 23454));
        department1.addEmployee(new ContractEmployee("Andrey", Category.MIDDLE, 34235, 125));
        department1.addEmployee(new ContractEmployee("Sergiy", Category.JUNIOR, 34234, 80));
        department1.addEmployee(new SalariedEmployee("Stas", Category.SENIOR, 23454));

        println("All Employee in ", department1.getName(), ":");
        List<Employee> list = department1.getEmployeeList();
        Collections.sort(list, EmployeeService.compareByName);
        EmployeeService.showInfo((ArrayList) list);

        Collections.sort(list, EmployeeService.compareBySalary);
        println();
        println("All Employee in ", department1.getName(), " sorted by salary:");
        EmployeeService.showInfo((ArrayList) list);


    }
}
