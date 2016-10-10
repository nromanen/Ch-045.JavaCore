package net.gavrilyuk.person;


import javax.swing.*;

/**
 * Add class Person to the project.
 * Class Person should consists of two private fields: name and birthYear (the birthday year)
 * properties for access to these fields default constructor and constructor with 2 parameters methods:
 * age - to calculate the age of person
 * input - to input information about person
 * output - to output information about person
 * changeName - to change the name of person
 * In the method main() create 5 objects of Person type and input information about them.

 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class PersonManager {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new PersonWindow("Person Manager").setVisible(true);
            }
        });

    }
}
