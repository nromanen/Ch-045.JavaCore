package homework5.employees;

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
public class ContractEmployee extends Employee{


    public double hourlyRate;
    public int hoursNumber;
    public String federalTaxIdMember;


    ContractEmployee(){}

    ContractEmployee(String name, String federalTaxIdMember, double hourlyRate, int hoursNumber, String department  ){
        this.name = name;
        this.employeeId = federalTaxIdMember;
        this.hourlyRate = hourlyRate;
        this.hoursNumber = hoursNumber;
        this.department = department;
    }

    public void setFederalTaxIdMember(String federalTaxIdMember) {
        this.federalTaxIdMember = federalTaxIdMember;
    }

    public String getFederalTaxIdMember() {
        return federalTaxIdMember;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHoursNumber(int hoursNumber) {
        this.hoursNumber = hoursNumber;
    }

    public int getHoursNumber() {
        return hoursNumber;
    }

    @Override
    public double calculatePay() {
        return hoursNumber * hourlyRate;
    }

    @Override
    public String toString(){
        return String.format("Name: %-10s Id: %-15s Salary: %-8.2f",name,employeeId,this.calculatePay());
    }
}
