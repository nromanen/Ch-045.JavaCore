package net.gavrilyuk.solvetasks.checkrange;

import java.util.Scanner;

/**
 * read 3 float numbers and check: are they all belong to the range [-5,5]
 * Created by Igor Gavrilyuk on 07.10.2016.
 */
public class CheckRangeApp {

    private static float readFloat(Scanner scanner) {
        String line = null;
        float result = 0;
        System.out.print("Enter an float :");
        while (scanner.hasNext()) {
            try {
                line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                result = Float.parseFloat(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid value:" + line);
                System.out.print("Enter an float :");
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FloatNumbers checkedNumbers = new FloatNumbers();
        for (int i = 0; i < 3; i++) {
            float val = readFloat(in);
            checkedNumbers.addNumber(val);
        }
        System.out.println(checkedNumbers.toString());
        System.out.println("all belong to the range [-5,5]:" + checkedNumbers.isRange(-5, 5));
        in.close();
    }
}
