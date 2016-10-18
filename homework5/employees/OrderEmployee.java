package homework5.employees;

import java.util.Comparator;
import java.util.List;

/**
 * Created by roma on 16.10.2016.
 */
public class OrderEmployee {
    public static Comparator<Employee> orderBySalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            double salary1 = (double) o1.calculatePay();
            double salary2 = (double) o2.calculatePay();

            if( salary1 < salary2 ) { return 1; }
            if( salary1 > salary2 ) { return  -1; }
            else return 0;

        }
    };

    public static void getEmployeesDepartment(List<Employee> employees,String department){
        for (Employee employee: employees){
            if(department == employee.getDepartment()){
                System.out.println(employee);
            }
        }
    }
}
