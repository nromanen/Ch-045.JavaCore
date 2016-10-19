package Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evil on 18.10.16.
 */
public class EmployeeMainApp {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        SalariedEmployee fill = new SalariedEmployee("Fill");
        ContractEmployee pif = new ContractEmployee("Pif");
        employees.add(fill);
        employees.add(pif);
        fill.setFixedPayment(3000);
        pif.setRateHours(23);
        pif.setWorkedHours(123);
        fill.calculatePay();
        pif.calculatePay();
        for (Employee employee : employees){
            employee.printInf();
        }

    }
}
