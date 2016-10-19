package collections.practice.task2;

import util.Scan;

import java.util.Map;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 19.10.16.
 */
public class Util {

    public static int getRandId(){
        return (int)(Math.random()* 666666);
    }

    public static boolean addToMap(int key, String value, Map<Integer, String> map){

        boolean isCorrectKey = false;
        while (!isCorrectKey) {
            if (map.containsKey(key)) {
                int newKey = getRandId();
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
}
