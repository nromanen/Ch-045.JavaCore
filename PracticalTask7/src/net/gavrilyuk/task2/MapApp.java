package net.gavrilyuk.task2;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * Created by Igor Gavryliuk on 17.10.2016.
 */

/*
        In the main() method declare map employeeMap of pairs <Integer, String>.
        1.Add to employeeMap seven pairs (ID, name) of some persons.
          Display the map on the screen.
        2.Ask user to enter ID, then find and write corresponding name from your map.
         If you can't find this ID - say about it to user (use function containsKey()).
        3.Ask user to enter name, verify than you have name in your map and write corresponding ID.
         If you can't find this name - say about it to user (use function containsValue()).
*/

public class MapApp {

    private static final int EMPLOYEE_COUNT = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeMap<Integer, String> employeeMap = new EmployeeMap<>();
        //fill map
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employeeMap.addEmployee(i + 1, "employee" + (i + 1));
        }
        employeeMap.addEmployee(7, "employee2");//add value some name(employee2) from test set from return getKeysByValue
        //employeeMap.addEmployee(8, null);

        System.out.println(employeeMap.printMap()); //System.out.println(employeeMap);

        // read key and find value
        int key = EmployeeMapUtil.readInt(scanner);
        if (employeeMap.getValueByKey(key) != null) {
            System.out.println("value="+employeeMap.getValueByKey(key));
        } else System.out.println("Key (" + key + ") doesn't exist");

        // read value and find key(s)
        String name = EmployeeMapUtil.readString(scanner);
        Set<Integer> keys = employeeMap.getKeysThanValue(name);
        if (!keys.isEmpty()) {
            System.out.println(keys);
        } else System.out.println("No key from value (" + name + ") found!");

        // test other types from EmployeeMap<type1,type2>

       /* EmployeeMap<String, String> employeeMap = new EmployeeMap<>();
        //fill map
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employeeMap.addEmployee("employee" + (i + 1),String.valueOf(i + 1) );
        }
        employeeMap.addEmployee("employee2",String.valueOf(7));//add value some name(employee2) from test set from return getKeysByValue
        //employeeMap.addEmployee(8, null);

        System.out.println(employeeMap.printMap()); //System.out.println(employeeMap);

        // read key and find value
        String key = EmployeeMapUtil.readString(scanner);
        if (employeeMap.getValuesByKey(key) != null) {
            System.out.println("value="+employeeMap.getValuesByKey(key));
        } else System.out.println("Key (" + key + ") doesn't exist");

        // read value and find key(s)
        String name = EmployeeMapUtil.readString(scanner);
        Set<String> keys = employeeMap.getKeysByValue(name);
        if (!keys.isEmpty()) {
            System.out.println(keys);
        } else System.out.println("No key from value (" + name + ") found!");
        scanner.close();*/
    }

}
