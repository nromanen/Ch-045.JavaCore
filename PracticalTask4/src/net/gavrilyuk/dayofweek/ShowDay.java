package net.gavrilyuk.dayofweek;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class ShowDay {

    private static int readInt(Scanner scanner) {
        String line = null;
        int result = 0;
        System.out.print("Enter the number of the day of the week[1-7]:");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result > 7 || result < 1) {
                    System.out.println(result+" invalid value!Day must be [1-7].");
                    System.out.print("Enter the number of the day of the week[1-7]:");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter the number of the day of the week[1-7]:");
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int day = readInt(in);
        //System.out.println("day of week =" + new DayConverter().getDayOfWeek());//test empty constructor
        System.out.println("day of week =" + new DayConverter(day).getDayOfWeek());
        System.out.println("day of week =" + new DayConverter(new Locale("ru"), day).getDayOfWeek());
        System.out.println("day of week =" + new DayConverter(new Locale("uk"), day).getDayOfWeek());
        in.close();
    }

}
