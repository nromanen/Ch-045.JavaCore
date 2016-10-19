package homework6.homework.task1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by roma on 17.10.2016.
 * Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 * realizing the operations of union and intersection of two sets.
 * Test the operation of these techniques on two pre-filled sets.

 */
public class SetApp {

    public static void main(String[] args){
        Set<Integer>set1 = new HashSet<Integer>();
        set1.add(9);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(8);
        set2.add(2);
        set2.add(3);
        set2.add(7);

        SetUtil setUtil = new SetUtil();

        //Union set1 - set2
        System.out.println("Union Set1 and Set2");
        for (Object set: setUtil.union(set1,set2)){
            System.out.print(set + " ");
        }

        //Intersect set1 - set2
        System.out.println("\nIntersect Set1 and Set2");
        for (Object set: setUtil.intersect(set1, set2)){
            System.out.print(set + " ");
        }
    }
}
