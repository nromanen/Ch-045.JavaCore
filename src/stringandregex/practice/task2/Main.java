package stringandregex.practice.task2;

import util.Scan;

import static util.Print.println;

/*
 * Enter surname, name and patronymic on the console as a variable of type String. Output on the console:
 *      surnames and initials
 *      name
 *      name, middle name and last name
 */
public class Main {
    public static void main(String[] args) {
        println("Enter full name of person:");
        Person p = new Person(Scan.getString(1));

        p.checkInit();

        println("Surname and initials are ", p.getShortName());
        println("Name is ", p.getName(), ".");
        println("Name, middle name and surname are ", p.getName(), " ", p.getPatronymic(), " ", p.getSurname(), ".");

    }


}
