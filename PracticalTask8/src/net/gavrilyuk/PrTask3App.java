package net.gavrilyuk;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 20.10.2016.
 */

        /*The user name can be 3 to 15 characters of the Latin alphabet, numbers, and underscores.
        Using regular expressions implement checking the user name for validity.
        Input five names in the main method .
        Output a message to the console of the validation of each of the entered names.*/

public class PrTask3App {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = PrStringsUtil.readString(scanner, "Enter username:");
        System.out.println("User name \'" + name + "\' is " + (PrStringsUtil.checkUserName(name) ? "valid" : "invalid"));
        scanner.close();
    }
}
