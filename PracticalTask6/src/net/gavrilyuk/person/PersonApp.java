package net.gavrilyuk.person;

/**
 * Create next structure.
 * In abstract class net.gavrilyuk.person.Person with property name, declare abstract method print().
 * In other classes in body of method print() output text “I am a …”.
 * In class net.gavrilyuk.person.Staff declare abstract method salary().
 * In each concrete class create constant TYPE_PERSON.
 * Output type of person in each constructors.
 * Create array of net.gavrilyuk.person.Person and add some Teachers, Cleaners and Students to it.
 * Call method print() for all of it.
 * Call method salary() for all Teachers and Cleaner

 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class PersonApp {

    public static void main(String[] args) {
        Person[] persons = new Person[10];
        for (int i = 0; i < persons.length; i++) {
            switch (i) {
                case 0:
                case 3:
                case 5:
                    persons[i]= new Student();
                    break;
                case 1:
                case 4:
                case 7:
                    persons[i]= new Cleaner();
                    break;
               default:persons[i]= new Teacher();
                    break;

            }
        }
        System.out.println("Call method print() and salary():");
        for (Person person : persons) {
            person.print();
            if (person instanceof Staff) {
                ((Staff) person).salary();
            }
        }
    //
    }
}
