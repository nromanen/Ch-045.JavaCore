package hohework5.practical.person;

import java.util.*;
import java.util.List;

/**
 * Created by roma on 13.10.2016.
 * Create next structure. In abstract class Person with property name, declare abstract method print().
 * In other classes in body of method print() output text “I am a …”.
 *
 * In class Staff declare abstract method salary().
 * In each concrete class create constant TYPE_PERSON.
 * Output type of person in each constructors.
 * Create array of Person and add some Teachers, Cleaners and Students to it.
 * Call method print() for all of it. Call method salary() for all Teachers and Cleaner
 */
public class AppPerson {
    public static void main(String[] args){

        Student student1 = new Student("david");
        Student student2 = new Student("elvis");
        Teacher teacher1 = new Teacher("soffi",80,200);
        Teacher teacher2 = new Teacher("stepan",90,200);
        Cleaner cleaner1 = new Cleaner("dora",60,150);
        Cleaner cleaner2 = new Cleaner("indi",50,140);

        List<Person> persons = new ArrayList<Person>();

        persons.add(student1);
        persons.add(student2);
        persons.add(teacher1);
        persons.add(teacher2);
        persons.add(cleaner1);
        persons.add(cleaner2);

        for (Person person: persons){
            System.out.println(person);
        }
    }
}
