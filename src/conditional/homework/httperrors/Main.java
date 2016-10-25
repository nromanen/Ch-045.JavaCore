package conditional.homework.httperrors;

import util.Scan;

import static util.Print.print;
import static util.Print.println;

/*
  * Solve the next task:
  *     read number of HTTP Error (400, 401,402, ...) and write the name of this error (Declare enum HTTPError)
  */
public class Main {

    public static void main(String[] args) {

        boolean isCorrect = false;

        do {
            print("Enter the number of the HTTP error: ");
            int errNumb = Scan.getInt();

                try {
                    println("Name of the " + errNumb + " error is " + HTTPErrors.getHTTPErrors(errNumb));
                    isCorrect = true;
                } catch (NoSuchHTTPErrorException e){
                    println(e.toString());
                    println("The invalid number of the HTTP error! Please try again!");
                }

        } while (!isCorrect);

        Scan.close();
    }
}
