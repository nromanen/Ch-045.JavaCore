package exception.homework.task1;

/* Create method div(), which calculates the dividing of two double numbers.
 * In main method input 2 double numbers and call this method.
 * Catch all exceptions.
 */

import exception.homework.task2.IncorrectIntegerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static util.Print.println;

public class Main {
    public static void main(String[] args) {

        Double d1 = 0.0;
        Double d2 = 0.0;
        try {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                d1 = Double.parseDouble(br.readLine());
                d2 = Double.parseDouble(br.readLine());
            } catch (IOException e) {
                println("IOException: " + e.getMessage());
                System.exit(-2);
            }

        } catch (NumberFormatException e){
            println("NumberFormatException: " + e.getMessage());
            System.exit(-3);
        }

        try {
            println(Util.div(d1, d2));
        } catch (ArithmeticException e) {
            println("ArithmeticException: " + e.getMessage());
            System.exit(-4);
        }
    }
}
