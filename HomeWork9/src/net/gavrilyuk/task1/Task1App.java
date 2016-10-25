package net.gavrilyuk.task1;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 25.10.2016.
 */

      /*  Create method div(), which calculates the dividing of two double numbers.
        In main method input 2 double numbers and call this method.
        Catch all exceptions*/

    public class Task1App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dividend = TaskUtils.readDouble(scanner, "dividend");
        double  divider = TaskUtils.readDouble(scanner,"divider");
        try {
            System.out.println(dividend+" / "+divider+" = "+TaskUtils.div(dividend,  divider));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();

    }

}
