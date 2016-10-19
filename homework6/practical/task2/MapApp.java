package homework6.practical.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by roma on 17.10.2016.
 * In the main() method declare map employeeMap of pairs <Integer, String>.

 Add to employeeMap seven pairs (ID, name) of some persons. Display the map on the screen.

 Ask user to enter ID, then find and write corresponding name from your map.
 If you can't find this ID - say about it to user (use function containsKey()).

 Ask user to enter name, verify than you have name in your map and write corresponding ID.
 If you can't find this name - say about it to user (use function containsValue()).

 */
public class MapApp {
    public static void main(String[] args){
        Employee emp1,emp2,emp3,emp4,emp5;

        emp1 = new Employee(1, "name");
        emp2 = new Employee(2, "name");
        emp3 = new Employee(1, "name");
        emp4 = new Employee(4, "second");
        emp5 = new Employee(5, "second");

        EmployeeMap employeeMap = new EmployeeMap();

        employeeMap.putEmpToMap(emp1);
        employeeMap.putEmpToMap(emp2);
        employeeMap.putEmpToMap(emp3);
        employeeMap.putEmpToMap(emp4);
        employeeMap.putEmpToMap(emp5);

        int searchId = 2;
        employeeMap.printMap();
        System.out.println(employeeMap.findNameById(searchId));

        String searchName = "second";
        Set<Integer> findIdSet = employeeMap.findIdByName(searchName);
        employeeMap.printSetIdName(findIdSet, searchName);



    }
}
