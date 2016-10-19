package net.gavrilyuk.task2;

import java.util.*;

/**
 *  Universal Employee Map Class
 * Created by Igor Gavryliuk on 17.10.2016.
 */
public class EmployeeMap<K, V>  {

    private Map<K, V> map;

    public EmployeeMap() {
        map = new HashMap<>();
    }


    public void addEmployee(K key, V value) throws NullPointerException {
            if (value == null)
                throw new NullPointerException(EmployeeMap.class.getSimpleName() + " does not allow for null values.");
            if (key == null)
                throw new NullPointerException(EmployeeMap.class.getSimpleName() + " does not allow for null keys.");
            map.put(key, value);
            // map.putIfAbsent(key, value);//will not replace an existing value

    }

    //return set of key(s) or empty set if not contains value
    public Set<K> getKeysThanValue(V value) {
        Set<K> keys = new HashSet<>();
        if (map.containsValue(value)) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
            }
        }
        return keys;
    }

    //return V or null if not contains key
    public V getValueByKey(K key) {
        //return map.getOrDefault(key, null); // Does not exist
        return map.containsKey(key) ? map.get(key) : null;
    }

    //print  map
    public String printMap() {
        StringBuilder builder = new StringBuilder();
        if (!map.isEmpty()) {
            for (Map.Entry<K, V> entry : map.entrySet())
                builder.append("key is:").append(entry.getKey()).append(" value is:").append(entry.getValue()).append("\n");
        } else {
            builder.append("Empty map!").append("\n");
        }
        return builder.toString();
    }


}
