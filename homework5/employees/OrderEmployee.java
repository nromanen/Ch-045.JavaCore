package homework5.employees;

import java.util.Comparator;

/**
 * Created by roma on 16.10.2016.
 */
public class OrderEmployee {
    public static Comparator<EmployeeCalculate> orderBySalary = new Comparator<EmployeeCalculate>() {
        @Override
        public int compare(EmployeeCalculate o1, EmployeeCalculate o2) {
            double salary1 = (double) o1.calculatePay();
            double salary2 = (double) o2.calculatePay();

            if( salary1 < salary2 ) { return 1; }
            if( salary1 > salary2 ) { return  -1; }
            else return 0;

        }
    };
}
