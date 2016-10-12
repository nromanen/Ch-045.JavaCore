package loopsandarrays.practice.employee;

import java.util.Comparator;

import static util.Print.println;


public class EmploeeService {

    // compare two employee by name
    public static Comparator<Employee> compareByName = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    // compare two employee by salary
    public static Comparator<Employee> compareBySalary = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e2.getSalary() - e1.getSalary();
        }
    };

    // display all employee in company ( no arguments) or in department (int number of department)
    public static void printAll(int... dep) {
        if (dep.length == 0) {
            for (int i = 0; i < Company.allEmployee.size(); i++) {
                println(Company.allEmployee.get(i));
            }
        } else {
            for (int i = 0; i < Company.allEmployee.size(); i++) {
                if(Company.allEmployee.get(i).getDepartmentNum() == dep[0]){
                    println(Company.allEmployee.get(i));
                }
            }
        }
    }


}
