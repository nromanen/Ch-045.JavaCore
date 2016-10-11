package lesson2.employee;

import java.util.Comparator;

import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class EmploeeService {

    public static boolean correctHours(int hours){
        if (hours >= 0 && hours <= 500) {
            return true;
        } else {
            return false;
        }
    }

    public static Comparator<Employee> compareByName = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    public static Comparator<Employee> compareByHour = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e2.getHours() - e1.getHours();
        }
    };

    public static Comparator<Employee> compareByRate = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getRate() - e2.getRate();
        }
    };

    public static Comparator<Employee> compareBySalary = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getSalary() - e2.getSalary();
        }
    };
    public static void printAll() {
        for (int i = 0; i < Department.allEmployee.size(); i++) {
            println(Department.allEmployee.get(i));
        }
    }

}
