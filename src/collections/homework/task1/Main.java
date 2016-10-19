package collections.homework.task1;

import java.util.Set;
import java.util.TreeSet;

import static collections.homework.task1.Util.intersect;
import static collections.homework.task1.Util.union;
import static util.Print.println;

/*
 * Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 * realizing the operations of union and intersection of two sets.
 * Test the operation of these techniques on two pre-filled sets.
 */
public class Main {

    public static void main(String[] args) {
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();

        set1.add("Test");
        set1.add("Test1");

        set2.add("Test");
        set2.add("Test2");

        Set<Integer> set3 = new TreeSet<>();
        Set<Integer> set4 = new TreeSet<>();

        set3.add(1);
        set3.add(2);
        set3.add(3);

        set4.add(1);
        set4.add(3);
        set4.add(4);

        println("Set1: ", set1);
        println("Set2: ", set2);
        println("Set3: ", set3);
        println("Set4: ", set4);

        println("----------------------------");

        Set<String> setUnion1 = union(set1, set2);
        Set<String> setInter1 = intersect(set1, set2);

        println("Union of set1 and set2: ", setUnion1);
        println("Intersect of set1 and set2: ", setInter1);

        Set<Integer> setUnion2 = union(set3, set4);
        Set<Integer> setInter2 = intersect(set3, set4);

        println("Union of set3 and set4: ", setUnion2);
        println("Intersect of set3 and set4: ", setInter2);

    }
}
