package net.gavrilyuk.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Employee Lab Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeLab {

    private static final String DB_FILENAME = "employee.json";
    private static EmployeeLab sEmployeeLab;

    private List<Employee> employees;
    private EmployeeJSONSerializer mSerializer;


    private EmployeeLab() {
        mSerializer = new EmployeeJSONSerializer(DB_FILENAME);
        try {
            employees = mSerializer.loadEmployee();
        } catch (Exception e) {
            employees = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public static EmployeeLab get() {
        if (sEmployeeLab == null) {
            sEmployeeLab = new EmployeeLab();
        }
        return sEmployeeLab;
    }

    public Employee getEmployee(UUID id) {
        for (Employee e : employees) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        saveEmployees();
    }

    public void removeEmployee(int index) {
        employees.remove(index);
        saveEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean saveEmployees() {
        try {
            mSerializer.saveEmployee(employees);
            //System.out.println("Employees saved to file");
            return true;
        } catch (Exception e) {
             //System.out.println("Error saving Employees: "+e.getMessage());
             e.printStackTrace();
            return false;
        }
    }
}
