package net.gavrilyuk.dayofmonth;

import java.util.Scanner;

/**
 * Ask user to enter the number of month.
 * Read the value and write the amount of days in this month (create array with amount days of each month).
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class DayOfMonthApp {



    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter an month number :");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an month number :");
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = readInt(scanner);
        System.out.println("Days of month:" + DayOfMonthUtil.daysInMonth(month, false));
        scanner.close();
    }

}
