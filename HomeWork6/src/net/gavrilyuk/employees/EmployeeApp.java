package net.gavrilyuk.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
         /*Create an interface to the method calculatePay(), the base class Employee with a string variable employeeld.
         Create two classes SalariedEmployee and ContractEmployee, which implement interface and are inherited from the base class.
         Describe hourly paid workers in the relevant classes (one of the children), and fixed paid workers (second child).
         Describe the string variable socialSecurityNumber in the class SalariedEmployee .
         Include a description of federalTaxIdmember in the class of contractEmployee .
         The calculation formula for the "time-worker“ is: "the average monthly salary = hourly rate * number of hours worked"
         For employees with a fixed payment the formula is: "the average monthly salary = fixed monthly payment“
         Create an array of employees and add the employees with different form of payment.
         Arrange the entire sequence of workers descending the average monthly wage.
         Output the employee ID, name, and the average monthly wage for all elements of the list.*/

public class EmployeeApp {

    public static void main(String[] args) {
        List<PaidWorker> employees = new ArrayList<>();
        //fill employee data
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                if (i % 4 == 0) {
                    employees.add(new SalariedEmployee("SalariedEmployee" + i, TariffRates.TARIFF_2));
                } else employees.add(new SalariedEmployee("SalariedEmployee" + i));
            } else {
                ContractEmployee employee;
                if (i % 3 == 0) {
                    employee = new ContractEmployee("ContractEmployee" + i, Department.SALES, HourlyRate.THIRD_RATE);
                    employee.setHoursWorked((i + 1) * 8);
                } else {
                    if (i % 11 == 0) {
                        employee = new ContractEmployee("ContractEmployee" + i, Department.ADMIN, HourlyRate.FIRST_RATE);
                    } else {
                        employee = new ContractEmployee("ContractEmployee" + i);
                        employee.setHoursWorked((i + 1) * 8);
                    }
                }
                employees.add(employee);
            }
        }
        //show array of workers descending the average monthly wage
        for (PaidWorker employee : EmplUtils.orderBySalary(employees)) {
            System.out.println(employee.toString());
        }
        System.out.println(EmplUtils.showDepChoicer());//Department show selection menu
        Scanner scanner = new Scanner(System.in);
        int dep = EmplUtils.readDepNumber(scanner);
        List<PaidWorker> filteredEmp= EmplUtils.filterByDep(dep, employees);
        //show array of workers filtered by department
        for (PaidWorker employee : filteredEmp) {
            System.out.println(employee.toString());
        }
        scanner.close();

    }




}
