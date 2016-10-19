package collections.practice.task2;

import util.Scan;

import java.util.Map;

import static util.Print.print;
import static util.Print.println;

public class Util {

    // Method return random integer from 0 to int n
    public static int getRandId(int n){
        return (int)(Math.random()* n);
    }

    // Method add key and value to map. If same key is in the map, key will be changed to another random key
    public static boolean addToMap(int key, String value, Map<Integer, String> map){

        boolean isCorrectKey = false;
        while (!isCorrectKey) {
            if (map.containsKey(key)) {
                int newKey = getRandId(Main.n);
                println("The key: ", key, " is in the map. Key was changed: ", newKey);
                key = newKey;
            } else{
                map.put(key, value);
                isCorrectKey = true;
                println("Added successful. Key: ", key, ", value: ", value, ".");
            }
        }
        return true;
    }

    // Method read key from console and write value of this key(if same key is in map)
    public static boolean printValueById(Map<Integer, String> map){
        int id;
        boolean isEnd = false;

        while (!isEnd){
            print("Enter ID of employee: ");
            id = Scan.getInt();
            if(map.containsKey(id)){
                println("Id : ", id, ", value: ", map.get(id));
                isEnd = true;
            } else{
                print("No such Id. Do you want to try again(Y/N): ");
                String s = Scan.getString(1);
                if(!s.toUpperCase().equals("Y")){
                    isEnd = true;
                }
            }

        }
        return true;
    }

    // Method read value from console and write key and value(if same value or values are in map)
    public static boolean printIdByValue(Map<Integer, String> map){
        String name;
        boolean isEnd = false;

        while (!isEnd){
            print("Enter full name of employee: ");
            name = Scan.getString(1);
            if(map.containsValue(name)){

                for (Map.Entry<Integer, String> item : map.entrySet()) {
                    if (item.getValue().equals(name)){
                        println("Id : ", item.getKey(), ", value: ", item.getValue());
                        isEnd = true;
                    }
                }

            } else{
                print("No such full name. Do you want to try again(Y/N): ");
                String s = Scan.getString(1);
                if(!s.toUpperCase().equals("Y")){
                    isEnd = true;
                }
            }

        }
        return true;
    }

    public static <T, U> boolean printMap(Map<T, U> map){
        for (Map.Entry<T, U> item : map.entrySet()) {
            println("{ ", item.getKey(), " : ", item.getValue(), " }");
        }
        return true;
    }
}
