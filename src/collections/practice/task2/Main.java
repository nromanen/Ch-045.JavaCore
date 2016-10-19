package collections.practice.task2;

import java.util.HashMap;
import java.util.Map;

import static collections.practice.task2.Util.*;
import static util.Print.println;

/*
 * In the main() method declare map employeeMap of pairs <Integer, String>.
 * Add to employeeMap seven pairs (ID, name) of some persons. Display the map on the screen.
 * Ask user to enter ID, then find and write corresponding name from your map.
 * If you can't find this ID - say about it to user (use function containsKey()).
 * Ask user to enter name, verify than you have name in your map and write corresponding ID.
 * If you can't find this name - say about it to user (use function containsValue()).
 */
public class Main {

    public static int n = 100;

    public static void main(String[] args) {

        Map<Integer, String> employeeMap = new HashMap<Integer, String>();



        addToMap(getRandId(n), new Employee("Ivan0", "Ivanov0").getFulName(), employeeMap);
        addToMap(getRandId(n), new Employee("Ivan1", "Ivanov1").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan2", "Ivanov2").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan3", "Ivanov3").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan4", "Ivanov4").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan5", "Ivanov5").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan6", "Ivanov6").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan1", "Ivanov1").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan8", "Ivanov8").getFulName(), employeeMap );
        addToMap(getRandId(n), new Employee("Ivan9", "Ivanov9").getFulName(), employeeMap );


        println("-----------------------------------------------------------");

        printMap(employeeMap);

        println("-----------------------------------------------------------");

        printValueById(employeeMap);

        println("-----------------------------------------------------------");

        printIdByValue(employeeMap);
    }


}
