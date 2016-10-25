package net.gavrilyuk.task1;

import java.util.Scanner;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class RectangleUtils {

    public static int readLengthOfSide(Scanner scanner, String value) {
        String line = null;
        int result = 0;
        System.out.print("Enter integer value " + value + "=");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Integer.parseInt(line);
                if (result >= 0 ) {
                    break;
                } else {
                    System.out.println(value + " must be >= 0 " );
                    System.out.print("Enter the valid integer value for " + value+"=");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter the valid integer value for " + value+"=");
            }
        }
        return result;
    }

    /*public static boolean isDigits(String source) {
        Pattern pattern = Pattern.compile("[//d+]");
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }*/

   /* public static boolean isDigits(String source) {
        for (Character c : source.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }*/

}
