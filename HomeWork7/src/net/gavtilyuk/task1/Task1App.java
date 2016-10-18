package net.gavtilyuk.task1;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */

        /*Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
        realizing the operations of union and intersection of two sets.
        Test the operation of these techniques on two pre-filled sets.*/

public class Task1App {


    public static void fillSet(OperateSet<Integer> set, int count, int k) {
        for (int i = 0; i < count; i++) {
            set.add((i+1)*k);
        }
    }
    public static void fillSet(OperateSet<String> set, int k) {
        for (int i = 0; i < 5; i++) {
            set.add("String"+(i+1)*k);
        }
    }


    public static void main(String[] args) {
        //test Integer type
        OperateSet<Integer> setInt1 = new OperateSet<>();
        fillSet(setInt1, 5, 1);
        OperateSet<Integer> setInt2 = new OperateSet<>();
        fillSet(setInt2, 5, 2);
       /* System.out.println("First element in ts: " + setInt1.first());
        System.out.println("Last element in ts: " + setInt1.last());
        System.out.println("First element > 0: " + setInt1.higher(0));
        System.out.println("First element < 10: " + setInt1.lower(10));*/
        System.out.println("setInt1: " + setInt1);
        System.out.println("setInt2: " + setInt2);
        System.out.println("Union: " + OperateSet.union(setInt1, setInt2));
        System.out.println("Intersection: " + OperateSet.intersection(setInt1, setInt2));
       /* System.out.println("Difference (setInt1 - setInt2): " + OperateSet.difference(setInt1, setInt2));
        System.out.println("Symmetric Difference: " + OperateSet.symDifference(setInt1, setInt2));
        //test other operations
        TreeSet<Integer> setInt3 = new TreeSet<>(setInt1);
        setInt3.remove(5);
        System.out.println("setInt3: " + setInt3);
        System.out.println("Is setInt1 a subset of setInt2? " + OperateSet.isSubset(setInt1, setInt3));
        System.out.println("Is setInt1 a superset of setInt2? " + OperateSet.isSuperset(setInt1, setInt3));
        System.out.println("Is setInt3 a subset of setInt1? " + OperateSet.isSubset(setInt3, setInt1));
        System.out.println("Is setInt3 a superset of setInt1? " + OperateSet.isSuperset(setInt3, setInt1));*/
        //test String type
        OperateSet<String> setStr1 = new OperateSet<>();
        fillSet(setStr1,1);
        OperateSet<String> setStr2 = new OperateSet<>();
        fillSet(setStr2,2);
        System.out.println("setInt1: " + setStr1);
        System.out.println("setInt2: " + setStr2);
        System.out.println("Union: " + OperateSet.union(setStr1, setStr2));
        System.out.println("Intersection: " + OperateSet.intersection(setStr1, setStr2));

    }


}
