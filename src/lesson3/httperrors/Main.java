package lesson3.httperrors;

import util.Scan;

import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class Main {

    public static void main(String[] args) {

        boolean isCorrect = false;

        do {
            print("Enter the number of the HTTP error: ");
            int errNumb = Scan.getInt();

            if (HTTPErrors.getHTTPErrors(errNumb) == null) {
                println("The invalid number of the HTTP error! Please try again!");
            } else {
                println("Name of the " + errNumb + " error is " + HTTPErrors.getHTTPErrors(errNumb));
                isCorrect = true;
            }
        } while (!isCorrect);

        Scan.close();
    }
}
