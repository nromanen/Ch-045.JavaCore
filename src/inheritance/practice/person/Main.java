package inheritance.practice.person;

import java.util.ArrayList;
import java.util.List;

 /*
  * Create next structure.
  *
  *
  *
  * In abstract class Person with property name, declare abstract method print().
  * In other classes in body of method print() output text “I am a …”.
  * In class Staff declare abstract method salary().
  * In each concrete class create constant TYPE_PERSON.
  * Output type of person in each constructors.
  * Create array of Person and add some Teachers, Cleaners and Students to it.
  * Call method print() for all of it. Call method salary() for all Teachers and Cleaner
  */
public class Main {

    public static void main (String ... args){

        List<Person> persons = new ArrayList<>();

        persons.add(new Teacher());
        persons.add(new Cleaner());
        persons.add(new Student());

        for (Person person : persons){
            person.print();
        }
    }
}
