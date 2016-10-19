package collections.homework.task2;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Util {

    // Method return true if in map are at less two persons with the same fullName
    public static <T, U> boolean personsWithSameName(Map<T, U> map){
        int count;
        for (Map.Entry<T, U> item : map.entrySet()) {
            count = 0;
            for (Map.Entry<T, U> item1 : map.entrySet()) {
                if(item.getValue().equals(item1.getValue())){
                    count++;
                    if(count == 2 ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Method remove from map all pairs with value = value
    public static <T, U> boolean removeByValue(U value, Map<T, U> map){
        if(map.containsValue(value)){
            Set<T> setKeyForRemove = new TreeSet<T>();
            for (Map.Entry<T, U> item : map.entrySet()) {
                if (item.getValue().equals(value)){
                    setKeyForRemove.add(item.getKey());
                }
            }
            for (T key : setKeyForRemove) {
                map.remove(key);
            }
            return true;
        }
        return false;
    }
}
