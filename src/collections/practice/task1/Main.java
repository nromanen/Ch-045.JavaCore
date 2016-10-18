package collections.practice.task1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static collections.practice.task1.Util.getMoreThan5;
import static collections.practice.task1.Util.insertElement;
import static collections.practice.task1.Util.removeGreatThanN;
import static util.Print.println;

/**
 * Created by Admin on 18.10.16.
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> myCollection = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            myCollection.add((int)(Math.random()*25));
        }

        println(myCollection);
        println();

        List<Integer> newCollection = getMoreThan5(myCollection);
        println(newCollection);

        removeGreatThanN(20, myCollection);

        println(myCollection);

        insertElement(2, 1, myCollection);
        insertElement(8, -3, myCollection);
        insertElement(5, -4, myCollection);

        println(myCollection);

        Collections.sort(myCollection);

        println(myCollection);



    }

}
