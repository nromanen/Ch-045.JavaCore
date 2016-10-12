package classandobject.practice.employee;

import java.util.Comparator;

import static util.Print.println;

// This class for service employee class
public class EmploeeService {

    // Method check correct data of hours
    public static boolean correctHours(int hours){
        if (hours >= 0 && hours <= 500) {
            return true;
        } else {
            return false;
        }
    }

    // Method compare two employee by name
    public static Comparator<Employee> compareByName = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    // Method compare two employee by hours
    public static Comparator<Employee> compareByHour = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e2.getHours() - e1.getHours();
        }
    };

    // Method compare two employee by rate
    public static Comparator<Employee> compareByRate = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getRate() - e2.getRate();
        }
    };

    // Method compare two employee by salary
    public static Comparator<Employee> compareBySalary = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getSalary() - e2.getSalary();
        }
    };

    // Method display all employee
    public static void printAll() {
        for (int i = 0; i < Department.allEmployee.size(); i++) {
            println(Department.allEmployee.get(i));
        }
    }

}
