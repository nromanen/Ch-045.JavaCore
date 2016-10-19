package collections.practice.task2;

import java.util.HashMap;
import java.util.Map;

import static collections.practice.task2.Util.*;
import static util.Print.println;

/**
 * Created by Admin on 19.10.16.
 */
public class Main {

    public static void main(String[] args) {

        Map<Integer, String> employeeMap = new HashMap<Integer, String>();

        addToMap(getRandId(), new Employee("Ivan0", "Ivanov0").getFulName(), employeeMap);
        addToMap(getRandId(), new Employee("Ivan1", "Ivanov1").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan2", "Ivanov2").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan3", "Ivanov3").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan4", "Ivanov4").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan5", "Ivanov5").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan6", "Ivanov6").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan1", "Ivanov1").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan8", "Ivanov8").getFulName(), employeeMap );
        addToMap(getRandId(), new Employee("Ivan9", "Ivanov9").getFulName(), employeeMap );


        println("-----------------------------------------------------------");

        println(employeeMap);

        printValueById(employeeMap);

        println("-----------------------------------------------------------");

        printIdByValue(employeeMap);
    }


}
