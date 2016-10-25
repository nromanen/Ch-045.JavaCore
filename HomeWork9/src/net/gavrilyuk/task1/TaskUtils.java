package net.gavrilyuk.task1;

import java.util.Scanner;

/**
 * Task1 Utils
 * Created by Igor Gavryliuk on 25.10.2016.
 */
public class TaskUtils {

    //for task1
    // returns the double entered from the console
    public static double readDouble(Scanner scanner, String value)  {
        String line = null;
        double result = 0;
        System.out.print("Enter double "+value+":");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Double.parseDouble(line);
                if (result < 0) {
                    throw new NumberFormatException("Invalid double value:" + result);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid double value:" + line);
                System.out.print("Enter double "+value+":");
            }
        }
        return result;
    }

    //for task1
    // return  dividend/divider
    public static double div(double dividend, double divider) throws ArithmeticException {

        if (divider == 0) throw new ArithmeticException("Division by zero");
        return dividend / divider;

    }


}
