package introduction;

import util.Scan;

import static util.Print.print;
import static util.Print.println;
import static util.Scan.getInt;
import static util.Scan.getString;

/**
 * Created by Ariezz on 29.09.16.
 */
public class NameAge {

    public static void main(String ... args){

        println("Enter your name and age:");

        print("Name: ");
        String name = getString(3);

        System.out.print("Age: ");
        int age = getInt();

        println("Where are you from, " + name + "?");
        print("Address: ");
        String address = getString(3);

        println();
        println("------------------------");
        println();

        println("Information:");
        println("Name: " + name + ".");
        println("Age: " + age + ".");
        println("Address: " + address + ".");

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
