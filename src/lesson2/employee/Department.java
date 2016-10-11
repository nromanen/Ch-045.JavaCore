package lesson2.employee;

import java.util.ArrayList;

import java.util.Collections;

/**
 * Created by Admin on 06.10.16.
 */
public class Department {

    public static ArrayList<Employee> allEmployee = new ArrayList<>();


    public static int totalSum(){
        int result = 0;
        for (Employee employee : allEmployee){
            result += employee.getHours();
        }
        return result;
    }

    public static void bonus(){
        Collections.sort(allEmployee, EmploeeService.compareByHour);

        for(int i = 0; i < 5; i++){
            allEmployee.get(i).setSalary((int)(allEmployee.get(i).getSalary() * 1.1));
        }
    }


}
