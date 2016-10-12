package classandobject.homework.person;

import static util.Print.println;

 /*
  * Create Console Application project in Java.
  * Add class Person to the project.
  * Class Person should consists of two private fields: name and birthYear (the birthday year)
  * properties for access to these fields
  * default constructor and constructor with 2 parameters
  * methods:
  *     age - to calculate the age of person
  *     input - to input information about person
  *     output - to output information about person
  *     changeName - to change the name of person
  *     In the method main() create 5 objects of Person type and input information about them.
  */

public class Main {

    public static void main(String... args){
        Person person = new Person("Roma", 1985, 5, 13);
        person.input("I study Java!");

        println(person.output());

        Person person1 = new Person();

        println(person1);
        println(person);

    }


}
