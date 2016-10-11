package homework4.practical.employee;

import java.util.*;

/**
 * Created by roma on 08.10.2016.
 * Create a class Employee with fields name, department number, salary.
 * Create five objects of class Employee.
 * Display
 *  * all employees of a certain department (enter department number in the console);
 *  * arrange workers by the field salary in descending order.
 */
public class Employee  implements Comparable {

    private String name;
    private int departmentNumber;
    private List<Employee> employees = new ArrayList<Employee>();
    private int salary;

    public Employee() {

    }

    public Employee(String name, int departmentNumber, int salary) {
        this.name = name;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void addArrayList(Employee employee) {
        employees.add(employee);
    }

    public void output() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void getEmployeeDep() {
        int numberDepartment = inputNumber("\nEnter department number (to search by this number) :\n");
        int countDepartment = 0;
        for (Employee employee : employees) {
            if (numberDepartment == employee.getDepartmentNumber()) {
                System.out.println(employee);
                countDepartment++;
            }
        }
        if (countDepartment == 0) {
            System.out.println("Department number - " + numberDepartment + " does not exist!");
        }
    }

    public void sortBySalary() {
        Collections.sort(employees);
    }

    public static int inputNumber(String message) {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(message);
            while (!scan.hasNextInt()) {
                System.out.print("not (int) number, enter true number: ");
                scan.next();
            }
            result = scan.nextInt();
        } while (result <= 0);
        //scan.close();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s  department: %-5d salary: %-5d ",name,departmentNumber,salary);
    }

    @Override
    public int compareTo(Object object) {
        Employee entry = (Employee) object;

        int result = entry.name.compareTo(entry.name);
        if (result != 0) {
            return result;
        }

        result = entry.salary - salary;
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }
}