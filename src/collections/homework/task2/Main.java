package collections.homework.task2;

import java.util.HashMap;
import java.util.Map;

import static collections.homework.task2.Util.*;
import static collections.practice.task2.Util.addToMap;
import static collections.practice.task2.Util.getRandId;
import static collections.practice.task2.Util.printMap;
import static util.Print.println;

/*
 * Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
 * Output the entities of the map on the screen.
 * There are at less two persons with the same firstName among these 10 people?
 * Remove from the map person whose firstName is ”Orest” (or other). Print result.

 */
public class Main {

    public static int n = 100;

    public static void main(String[] args) {

        Map<Integer, String> personMap = new HashMap<Integer, String>();

        addToMap(getRandId(n), new Person("Ivan0", "Ivanov0").getFulName(), personMap);
        addToMap(getRandId(n), new Person("Ivan1", "Ivanov1").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan2", "Ivanov2").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan3", "Ivanov3").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan4", "Ivanov4").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan5", "Ivanov5").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan6", "Ivanov6").getFulName(), personMap);
        addToMap(getRandId(n), new Person("Ivan1", "Ivanov1").getFulName(), personMap );
        addToMap(getRandId(n), new Person("Ivan9", "Ivanov9").getFulName(), personMap);
        addToMap(getRandId(n), new Person("Ivan8", "Ivanov8").getFulName(), personMap);

        println("-----------------------------------------------------------");
        printMap(personMap);
        println("-----------------------------------------------------------");
        println(personsWithSameName(personMap));
        println("-----------------------------------------------------------");
        removeByValue("Ivan1 Ivanov1", personMap);
        printMap(personMap);
    }


}
