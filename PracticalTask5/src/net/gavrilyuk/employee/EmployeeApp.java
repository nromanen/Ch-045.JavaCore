package net.gavrilyuk.employee;

import java.util.Random;
import java.util.Scanner;

/**
 * Create a class Employee with fields name, department number, salary. Create five objects of class Employee. Display
 * all employees of a certain department (enter department number in the console);
 * arrange workers by the field salary in descending order.

 * Created by Igor Gavrilyuk on 08.10.2016.
 */
public class EmployeeApp {

    private static final int EMP_COUNT = 5;

    private static int readDep(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter department number:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter department number:");
            }
        }
        return result;
    }

    private static void fillEmployeeList(Employees employees) {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < EMP_COUNT; i++) {
            employees.addEmployee(new NewEmployee("Employee" + i,
                    //i % 2 == 0 ? 1 : i % 3 == 0 ? 3 : 2,
                    r.nextInt(3),
                    r.nextInt(1000)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employees employees = new Employees();
        fillEmployeeList(employees);
        System.out.println(employees.toString());
        int dep = readDep(scanner);
        employees.orderBySalary(true);
        System.out.println();
        //todo fix issue #8
        if (employees.getEmpOnDepartment(dep).size() > 0) {
            for (NewEmployee employee : employees.getEmpOnDepartment(dep)) {
                System.out.println(employee.toString());
            }
        } else System.out.println("Opps..No employees in the department "+dep);
        scanner.close();
    }
}
