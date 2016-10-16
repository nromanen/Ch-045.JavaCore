package homework5.employees;

import java.util.*;
/**
 * Created by roma on 13.10.2016.
 * Create an interface to the method calculatePay(), the base class Employee with a string variable employeeId.
 * Create two classes SalariedEmployee and ContractEmployee, which implement interface and are inherited from the base class.
 * Describe hourly paid workers in the relevant classes (one of the children),
 * and fixed paid workers (second child).
 * Describe the string variable socialSecurityNumber in the class SalariedEmployee .
 * Include a description of federalTaxIdMember in the class of contractEmployee .

 * The calculation formula for the "time-worker“ is:
 "the average monthly salary = hourly rate * number of hours worked"

 * For employees with a fixed payment the formula is:
 "the average monthly salary = fixed monthly payment“

 * Create an array of employees and add the employees with different form of payment.
 * Arrange the entire sequence of workers descending the average monthly wage.
 * Output the employee ID, name, and the average monthly wage for all elements of the list.
 */
public class AppEmployee {

    public static void main(String[] args){

        ContractEmployee contEmp1 = new ContractEmployee("Qvadra", "xzz1098760", HourlyRate.RATE_20.hourlyRate, HoursNumber.HOURS_100.hours );
        ContractEmployee contEmp2 = new ContractEmployee("Topass", "cty2088459",HourlyRate.RATE_30.hourlyRate, HoursNumber.HOURS_130.hours);
        ContractEmployee contEmp3 = new ContractEmployee("Sertio", "suz3038568",HourlyRate.RATE_40.hourlyRate, HoursNumber.HOURS_160.hours);

        SalariedEmployee salEmp1 = new SalariedEmployee("Ertops", "werwr164353", SalaryType.JUNIOR.salary);
        SalariedEmployee salEmp2 = new SalariedEmployee("Doryes", "poiu1089567", SalaryType.JUNIOR.salary);
        SalariedEmployee salEmp3 = new SalariedEmployee("Nestor", "opwr1096865", SalaryType.JUNIOR.salary);

        List<EmployeeCalculate> employees = new ArrayList<EmployeeCalculate>();

        employees.add(contEmp1);
        employees.add(contEmp2);
        employees.add(contEmp3);
        employees.add(salEmp1);
        employees.add(salEmp2);
        employees.add(salEmp3);

        System.out.println("List employees:");
        for (EmployeeCalculate employee: employees){
            System.out.println(employee);
        }
        Collections.sort(employees, OrderEmployee.orderBySalary);

        System.out.println("\nList employees average by monthly wage:");
        for (EmployeeCalculate employee: employees){
            System.out.println(employee);
        }
    }
}
