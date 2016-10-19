package net.gavtilyuk.task2;

import java.util.Map;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */

        /*Create map personMap and add to it ten persons of type <Integer, Employee> (ID, Employee).
        1. Output the entities of the map on the screen.
        2. There are at less two persons with the same firstName among these 10 people?
        3. Remove from the map person whose firstName is ”Orest” (or other).
        4. Print result.*/


public class Task2App {

    public static void main(String[] args) {
        EmployeeService personMap = new EmployeeService();
        try {
            personMap.fillMap(10);
        } catch (IllegalArgumentException e) {
            //System.out.println(e.getMessage());//ignore
        }

        System.out.println(personMap);
        if (personMap.isDuplicateFirstName()) {
            System.out.println("Wow! There are at less two persons with the same firstName!");
        } else System.out.println("Oops! No persons with the same firstName!");
        System.out.println();
        System.out.println("Persons with same firstName:\n"+personMap.printMap(personMap.findDuplicateFirstNames()));
        System.out.println();
        System.out.println("Persons with same lastName:\n" + personMap.printMap(personMap.findDuplicateLastNames()));
        System.out.println();
        if (personMap.findDuplicateNames().isEmpty()) {
            System.out.println("No persons with the same firstName and LastName!");
        } else System.out.println("Persons with same lastName and FirsName:\n"+ personMap.printMap(personMap.findDuplicateNames()));
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

        Map<Integer,Employee> map =  personMap.withoutDuplicatesByFirsName(nameFromDelete);
        System.out.println("Map after remove person whose firstName is "+ nameFromDelete+":\n"+personMap.printMap(map));


    }
}
