package net.gavtilyuk.task2;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */

        /*Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
        1. Output the entities of the map on the screen.
        2. There are at less two persons with the same firstName among these 10 people?
        3. Remove from the map person whose firstName is ”Orest” (or other).
        4. Print result.*/


public class Task2App {

    public static void main(String[] args) {
        PersonMap personMap = new PersonMap();
        personMap.fillMap(10);
        System.out.println(personMap);
        if (personMap.findDuplicateName()) {
            System.out.println("There are at less two persons with the same firstName!");
        } else System.out.println("No persons with the same firstName!");
        System.out.println();
        if (personMap.getDuplicateNamesMap().isEmpty()) {
            System.out.println("No persons with the same firstName!");
        } else System.out.println("Check names="+personMap.getDuplicateNamesMap());
        System.out.println();
        String nameFromDelete = "Ihor";
        /*if (personMap.removeWithFirsName(nameFromDelete)) {
            System.out.println("Person whose firstName is "+nameFromDelete+" removed.");
        } else System.out.println("No name "+nameFromDelete+" found in map.");*/
        /*int removedCount = personMap.countRemoveWithFirsName(nameFromDelete);
        if (removedCount>0) {
            System.out.println(removedCount+" person whose firstName is "+nameFromDelete+" removed.");
        } else System.out.println("No name "+nameFromDelete+" found in map.");
        System.out.println();
        System.out.println(personMap);*/
        System.out.println("After deleted fistName "+ nameFromDelete+" "+personMap.withoutDuplicateFirsName(nameFromDelete));


    }
}
