package Introduction;

import static Introduction.Scan.getInt;
import static Introduction.Scan.getString;

/**
 * Created by Ariezz on 29.09.16.
 */
public class NameAge {

    public static void main(String ... args){

        System.out.println("Enter your name and age:");

        System.out.print("Name: ");
        String name = getString(3);

        System.out.print("Age: ");
        int age = getInt();

        System.out.println("Where are you from, " + name + "?");
        System.out.print("Address: ");
        String address = getString(3);

        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        System.out.println("Information:");
        System.out.println("Name: " + name + ".");
        System.out.println("Age: " + age + ".");
        System.out.println("Address: " + address + ".");

        Scan.scanner.close();
    }
}

class Person{
    String name;
    int age;
    String address;

    public Person(String name) {
        this.name = name;
    }

    public Person(String address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }
}
