package net.gavrilyuk.talks;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 29.09.2016.
 */
public class TalkUtil {

    private static final String[] COUNTRIES = {"Ukraine", "Nigeria","Portugal"};

    // one hour = 60 min = 60*60 = 3600 sec
    // one day = 60*24= 1440 min = 86400 sec
    //one year = 525 600 min = 31536000 sec
    public static String getDurationToString(double duration) {
        long totalSecs =  Math.round(duration * 60);//convert 1.5 minutes to 90 seconds
        long years = totalSecs / 31536000;
        long days = (totalSecs % 31536000) / 86400;
        long hours = totalSecs % 86400 / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;
        return String.format("%d years %d days %d hours %d minutes %d seconds", years, days, hours, minutes, seconds);
    }

    public static double readDouble(Scanner scanner, String value, String country) {
        String line = null;
        double result = 0;
        System.out.print("Enter the "+value+" of call to "+country+":");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Double.parseDouble(line);
                if (result >= 0 && result <= Long.MAX_VALUE) {
                    break;
                } else {
                    System.out.println(value + " must be >= 0 and < " + String.format("%,d", Long.MAX_VALUE) );
                            System.out.print("Enter the " + value + " of call to " + country + ":");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter the "+value+" of call to "+country+":");
            }
        }
        return result;
    }

    public static String getCountryName(int index) {
        String result;
        try {
            result = COUNTRIES[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }
}
