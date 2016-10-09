package net.gavrilyuk.untilpositive;

import java.util.Scanner;

/**
 * Organize entering integers until the first negative number.
 * Count the product of all entered even numbers.
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class UntilPositiveApp {

    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter an integer :");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an integer :");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PositiveValues positiveValues = new PositiveValues();
        int value;
        do {
            value = readInt(scanner);
            positiveValues.checkValue(value);
        } while (value>=0);
        System.out.println("Production positive values ="+positiveValues.getProductions());
        scanner.close();
    }
}
