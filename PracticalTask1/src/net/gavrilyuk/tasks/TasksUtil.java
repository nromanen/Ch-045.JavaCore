package net.gavrilyuk.tasks;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 10.10.2016.
 */
public class TasksUtil {

    public static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter an integer :");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result == 0) throw new ArithmeticException("You can not divide by zero!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an integer :");
            } catch (ArithmeticException ea) {
                System.out.println(ea.getMessage());
                System.out.print("Enter an integer :");
            }
        }
        return result;
    }


}
