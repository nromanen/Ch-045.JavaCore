package net.gavrilyuk.task2;

import java.util.Scanner;

/**
 * EmployeeMapUtil Class
 * Created by Igor Gavryliuk on 17.10.2016.
 */
public class EmployeeMapUtil {

    // returns the key entered from the console
    public static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter key:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result < 0) {
                    throw new NumberFormatException("Invalid key value:" + result);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid key value:" + line);
                System.out.print("Enter key:");
            }
        }
        return result;
    }
    // returns the value entered from the console
    public static String readString(Scanner scanner) {
        String line = null;
        System.out.print("Enter name value:");
        while (scanner.hasNext()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.length() > 0) {
                break;
            } else {
                System.out.println("value must be not empty!");
                System.out.print("Enter name value:");
            }

        }
        return line;
    }

}
