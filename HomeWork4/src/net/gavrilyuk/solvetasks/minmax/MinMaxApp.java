package net.gavrilyuk.solvetasks.minmax;

import java.util.Scanner;

/**
 * read 3 integer numbers and write max and min of them
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class MinMaxApp {

    private static final int NUMBERS_COUNT = 3;

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
           Scanner in = new Scanner(System.in);
           CheckedNumbers checkedNumbers = new CheckedNumbers();
            for (int i = 0; i < NUMBERS_COUNT; i++) {
                int val = readInt(in);
                checkedNumbers.addNumber(val);
            }
            System.out.println(checkedNumbers.toString());
            System.out.println("min="+checkedNumbers.getMin());
            System.out.println("max="+checkedNumbers.getMax());
            in.close();
    }
}
