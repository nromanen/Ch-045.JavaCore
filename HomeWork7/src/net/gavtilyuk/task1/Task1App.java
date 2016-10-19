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
        OperateSet<Integer> operateSet1 = new OperateSet<>();
        fillSet(operateSet1, 5, 1);
        OperateSet<Integer> operateSet2 = new OperateSet<>();
        fillSet(operateSet2, 5, 2);
       /* System.out.println("First element in ts: " + operateSet1.getSet().first());
        System.out.println("Last element in ts: " + operateSet1.getSet().last());
        System.out.println("First element > 0: " + operateSet1.getSet().higher(0));
        System.out.println("First element < 10: " + operateSet1.getSet().lower(10));*/
        System.out.println("operateSet1: " + operateSet1.getSet());
        System.out.println("operateSet2: " + operateSet2.getSet());
        System.out.println("Union: " + OperateSet.union(operateSet1.getSet(), operateSet2.getSet()));
        System.out.println("Intersection: " + OperateSet.intersection(operateSet1.getSet(), operateSet2.getSet()));
       /* System.out.println("Difference (operateSet1 - operateSet2): " + OperateSet.difference(operateSet1.getSet(), operateSet2.getSet()));
        System.out.println("Symmetric Difference: " + OperateSet.symDifference(operateSet1.getSet(), operateSet2.getSet()));
        //test other operations
        TreeSet<Integer> setInt3 = new TreeSet<>(operateSet1.getSet());
        setInt3.remove(5);
        System.out.println("setInt3: " + setInt3.getSet());
        System.out.println("Is operateSet1 a subset of operateSet2? " + OperateSet.isSubset(operateSet1.getSet(), setInt3.getSet()));
        System.out.println("Is operateSet1 a superset of operateSet2? " + OperateSet.isSuperset(operateSet1.getSet(), setInt3.getSet()));
        System.out.println("Is setInt3 a subset of operateSet1? " + OperateSet.isSubset(setInt3.getSet(), operateSet1.getSet()));
        System.out.println("Is setInt3 a superset of operateSet1? " + OperateSet.isSuperset(setInt3.getSet(), operateSet1.getSet()));*/

        //test String type
        OperateSet<String> setStr1 = new OperateSet<>();
        fillSet(setStr1,1);
        OperateSet<String> setStr2 = new OperateSet<>();
        fillSet(setStr2,2);
        System.out.println("operateSet1: " + setStr1.getSet());
        System.out.println("operateSet2: " + setStr2.getSet());
        System.out.println("Union: " + OperateSet.union(setStr1.getSet(), setStr2.getSet()));
        System.out.println("Intersection: " + OperateSet.intersection(setStr1.getSet(), setStr2.getSet()));

    }


}
