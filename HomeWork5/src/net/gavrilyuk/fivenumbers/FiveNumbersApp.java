package net.gavrilyuk.fivenumbers;

import java.util.Scanner;

/**
 * Enter 5 integer numbers. Find
 * position of second positive number;
 * minimum and its position in the array.
 * Created by Igor Gavrilyuk on 09.10.2016.
 */
public class FiveNumbersApp {

    private static final int INTEGER_COUNT=5;

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
        NumbersScope scope = new NumbersScope();
        for (int i = 0; i < INTEGER_COUNT; i++) {
            scope.addValue(readInt(scanner));
        }
        System.out.println(scope.toString());
        //todo fix issue #6
        if (scope.findPosSecondPositive() == -1) {
            System.out.println("No second positive present");
        } else  System.out.println("Position ="+scope.findPosSecondPositive());
        System.out.println(scope.getMinAndPosition());
        scanner.close();

    }
}
