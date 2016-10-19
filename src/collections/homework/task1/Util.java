package collections.homework.task1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static util.Print.println;

public class Util {

    // Method return Set than contains elements from set1 and set2
    public static <T> Set<T> union(Set<T> set1, Set<T> set2){

        Set<T> set = new TreeSet<T>();

        set.addAll(set1);
        set.addAll(set2);

        //println(set);
        return set;
    }

    // Method return Set than contains elements which are in set1 and in set2(only duplicated elements)
    public static  <T> Set<T> intersect(Set<T> set1, Set<T> set2){

        Set<T> set = new TreeSet<T>();

        Iterator iterator = set1.iterator();

        while(iterator.hasNext()){

            T t = (T)iterator.next();

            if(set2.contains(t)) {
                set.add(t);
            }
        }
        //println(set);

        return set;
    }
}
