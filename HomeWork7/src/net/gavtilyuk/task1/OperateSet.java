package net.gavtilyuk.task1;

import java.util.Set;
import java.util.TreeSet;

/**
 *  OperateSet example Class from set operations: union, intersection,
 *  difference, symmetric difference, is subset, is superset
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class OperateSet<T>  {

    Set<T> set = new TreeSet<>(); //?

    public boolean add(T t) {
        return  set.add(t);
    }

    public Set<T> getSet() {
        return set;
    }

    public void setSet(Set<T> set) {
        this.set = set;
    }

    //union (обєднання) SetA SetB
    public static  <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;

    }
    //intersection (перетин) SetA SetB
    public static  <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new TreeSet<>();
        for (T x : set1)
            if (set2.contains(x))
                result.add(x);
        return result;
    }

    //difference (різниця) SetA SetB
    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set<T> result = new TreeSet<>(set1);
        result.removeAll(set2);
        return result;
    }
    // symmetric difference (симетрична різниця)
    public static <T> Set<T> symDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet;
        Set<T> intersectionSet;
        unionSet = union(set1, set2);
        intersectionSet = intersection(set1, set2);
        return difference(unionSet, intersectionSet);
    }
    // subset  SetB (підмножина) SetA
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);
    }

    // superset (SetA включає в себе SetB)
    public static <T> boolean isSuperset(Set<T> set1, Set<T> set2) {
        return set1.containsAll(set2);
    }


}
