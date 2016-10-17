package homework6.practical;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roma on 17.10.2016.
 * In the main() method declare map employeeMap of pairs <Integer, String>.

        Add to employeeMap seven pairs (ID, name) of some persons. Display the map on the screen.

        Ask user to enter ID, then find and write corresponding name from your map.
        If you can't find this ID - say about it to user (use function containsKey()).

        Ask user to enter name, verify than you have name in your map and write corresponding ID.
        If you can't find this name - say about it to user (use function containsValue()).

 */
public class Task2 {

    public static Map<Integer, String> employeeMap;

    public static void main(String[] args){

        employeeMap = new HashMap<>();

        employeeMap.put(11,"danko");
        employeeMap.put(12,"eroos");
        employeeMap.put(13,"root");
        employeeMap.put(14,"admin");
        employeeMap.put(15,"dir");
        employeeMap.put(16,"format");
        employeeMap.put(17,"sudo");

        //Display Map employeeMap
        for(Map.Entry empl: employeeMap.entrySet()){
            System.out.println("Key - "+empl.getKey()+" value - "+empl.getValue() );
        }

        //Ask user to enter ID, then find and write corresponding name from your map.
        //If you can't find this ID - say about it to user (use function containsKey()).

        //Search key
        isKey(12);

        //Search value
        isValue("root");


    }
    public static void isKey(int key){
        if(employeeMap.containsKey(key)){
            for(Map.Entry empl: employeeMap.entrySet()){
                if (empl.getKey().equals(key)){
                    System.out.println("Search (key "+key+") value - "+empl.getValue() );
                }
            }
        } else {
            System.out.print("Can't find this ID");
        }
    }

    public static void isValue(String value){
        if(employeeMap.containsValue(value)){
            for (Map.Entry empl:employeeMap.entrySet()){
                if (empl.getValue().equals(value)){
                    System.out.println("Search (value "+value+") key - "+empl.getKey() );
                }
            }
        } else {
            System.out.print("Can't find this Value");
        }
    }
}
