package homework6.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by roma on 17.10.2016.
 * Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 * realizing the operations of union and intersection of two sets.
 * Test the operation of these techniques on two pre-filled sets.

 */
public class SetUtil {
    public static Set<Integer> set1;
    public static Set<Integer> set2;
    public static Set<Integer> unionSet;
    public static Set<Integer> intersectSet;

    public static void main(String[] args){
        set1 = new HashSet();
        set1.add(9);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2 = new HashSet();
        set2.add(8);
        set2.add(2);
        set2.add(3);
        set2.add(7);

        //Union set1 - set2
        System.out.println("Union Set1 and Set2");
        for (Integer set: getUnionSet(set1,set2)){
            System.out.println(set+" ");
        }

        //Intersect set1 - set2
        System.out.println("Intersect Set1 and Set2");
        for (Integer set: getIntersectSet(set1, set2)){
            System.out.println(set+" ");
        }
    }
    public static Set<Integer> getUnionSet(Set<Integer> set1, Set<Integer> set2 ){
        unionSet = new HashSet();

        unionSet.addAll(set1);
        unionSet.addAll(set2);

        return unionSet;
    }

    public static Set<Integer> getIntersectSet(Set<Integer> set1, Set<Integer> set2){
        intersectSet = new HashSet<>();

        intersectSet.addAll(set1);
        intersectSet.retainAll(set2);

        return intersectSet;
    }

}
