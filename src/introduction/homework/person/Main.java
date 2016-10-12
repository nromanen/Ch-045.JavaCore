package introduction.homework.person;

import util.Scan;
import static util.Print.print;
import static util.Print.println;
import static util.Scan.getInt;
import static util.Scan.getString;

 /*
  * Define string variable name and integer value age.
  * Output question "What is your name?" Read the value name
  * and output next question: “Where are you live, (name)?".
  * Read address and write whole information.
  */

public class Main {

    public static void main(String ... args){

        print("Enter your name: ");
        String name = getString(3);

        Person person = new Person(name);

        System.out.print("Enter you age: ");
        int age = getInt();

        person.setAge(age);

        print("Where are you from, ", person.getName(),  "?");
        String address = getString(3);
        person.setAddress(address);

        println();
        println("------------------------");
        println();

        println("Information:");
        println("Name: ", person.getName(), ".");
        println("Age: ", person.getAge(), ".");
        println("Address: ", person.getAddress(), ".");

        Scan.close();
    }
}
