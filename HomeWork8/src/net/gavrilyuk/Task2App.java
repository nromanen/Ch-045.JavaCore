package net.gavrilyuk;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 20.10.2016.
 */

        /*Enter a sentence that contains the words between more than one space.
        Convert all spaces, consecutive, one.
        For example, if we introduce the sentence
        "I    am      learning     Java   Core,    what   next    ? ", we have to get the "I'm learning Java Core, what next?»*/

public class Task2App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String source = "I    am      learning     Java   Core";
        String source = StringsUtil.readString(scanner, "Enter a sentence that contains the words between more than one space:");
        try {
            System.out.println("Result=\'"+StringsUtil.removeSpaces(source)+"\'");
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
        scanner.close();
    }
}
