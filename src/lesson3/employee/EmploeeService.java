package lesson3.employee;

import java.util.Comparator;

import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class EmploeeService {

       public static Comparator<Employee> compareByName = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    public static Comparator<Employee> compareBySalary = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            return e2.getSalary() - e1.getSalary();
        }
    };

    public static void printAll(int... dep) {
        if (dep.length == 0) {
            for (int i = 0; i < Department.allEmployee.size(); i++) {
                println(Department.allEmployee.get(i));
            }
        } else {
            for (int i = 0; i < Department.allEmployee.size(); i++) {
                if(Department.allEmployee.get(i).getDepartmentNum() == dep[0]){
                    println(Department.allEmployee.get(i));
                }
            }
        }
    }


}
