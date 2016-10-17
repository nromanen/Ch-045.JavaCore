package net.gavrilyuk.task2;

import java.util.*;

/**
 *  Universal Employee Map Class
 * Created by Igor Gavryliuk on 17.10.2016.
 */
public class EmployeeMap<K, V> extends HashMap<K, V> {


    private static final String NEW_LINE = System.getProperty("line.separator");// new line

    private Map<K, V> map = new HashMap<>();

    public EmployeeMap() {
        super();
    }

    public void addAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    public int size() {
        return map.size();
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return map.remove(key, value);
    }

    @Override
    public void clear() {
        map.clear();
    }

    public Map<K, V> getMap() {
        return map;
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }


    public void putEmployee(K key, V value) {
        try {
            if (value == null)
                throw new NullPointerException(EmployeeMap.class.getSimpleName() + " does not allow for null values.");
            if (key == null)
                throw new NullPointerException(EmployeeMap.class.getSimpleName() + " does not allow for null keys.");
            map.put(key, value);
            // map.putIfAbsent(key, value);//will not replace an existing value
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }

    }

    //return set of key(s) or empty set if not contains value
    public Set<K> getKeysByValue(V value) {
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
    public V getValuesByKey(K key) {
        //return map.getOrDefault(key, null); // Does not exist
        return map.containsKey(key) ? map.get(key) : null;
    }

    //print  map
    public String printMap() {
        StringBuilder builder = new StringBuilder();
        if (!map.isEmpty()) {
            for (Map.Entry<K, V> entry : map.entrySet())
                builder.append("key is:").append(entry.getKey()).append(" value is:").append(entry.getValue()).append(NEW_LINE);
        } else {
            builder.append("Empty map!").append(NEW_LINE);
        }
        return builder.toString();
    }



    @Override
    public String toString() {
        return "EmployeeMap{" +
                "map=" + map +
                '}';
    }
}
