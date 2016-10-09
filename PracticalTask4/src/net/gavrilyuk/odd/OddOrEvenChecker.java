package net.gavrilyuk.odd;

import java.util.Scanner;

/**
 * Check Odd Class check of number odd or even
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class OddOrEvenChecker {

    private static final int NUMBERS_COUNT = 3;//the count of numbers to enter

    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter an integer to check if it is odd or even:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an integer to check if it is odd or even:");
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OddOrEven oddOrEven = new OddOrEven();
        for (int i = 0; i < NUMBERS_COUNT; i++) {
             int x = readInt(in);
             oddOrEven.addValue(x);
        }
        System.out.println(oddOrEven.toString());
        in.close();
    }


}
