package homework5.employees;

/**
 *  * Created by roma on 13.10.2016.
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
public abstract class Employee  implements EmployeeCalculate{

    public String name;

    public String department;

    public String employeeId;

    public Employee(){};

    public Employee(String name, String employeeId){
        this.name = name;
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

}
