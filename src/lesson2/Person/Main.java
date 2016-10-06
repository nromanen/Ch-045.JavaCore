package lesson2.person;

import static util.Print.println;

public class Main {

    public static void main(String... args){
        Person person = new Person(1985, 5, 13, "Roma");
        person.input("I study Java!");

        println(person.output());

        Person person1 = new Person();

        println(person1);

    }


}
