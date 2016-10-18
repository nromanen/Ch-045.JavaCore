package inheritance.homework.employee;

import java.util.ArrayList;
import java.util.Comparator;

import static util.Print.println;

/**
 * Created by Admin on 18.10.16.
 */
public class EmployeeService {

    public static double getRate(Employee employee){
        Category category = employee.getCategory();

        switch (category){
            case BEGINNER:
                return 2.75;
            case JUNIOR:
                return 4.35;
            case MIDDLE:
                return 6.00;
            case SENIOR:
                return 10;
        }
        return 0;
    }

    // compare two employee be name
    public static Comparator<Employee> compareByName = new Comparator<Employee>(){
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    //compare two employee be salary
    public static Comparator<Employee> compareBySalary = new Comparator<Employee>(){
        @Override
        public int compare(Employee o1, Employee o2) {
            if(o1.calculatePay() > o2.calculatePay())
                return 1;
            else if (o1.calculatePay() == o2.calculatePay())
                return 0;
            else return -1;
        }
    };

    //Show info by list of employees
    public static void showInfo(ArrayList<Employee> employees){
        for (Employee employee : employees) {
            println(employee);
        }
    }
}
