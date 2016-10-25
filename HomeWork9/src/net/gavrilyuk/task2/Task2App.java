package net.gavrilyuk.task2;

/**
 * Task2 App
 * Created by Igor Gavryliuk on 25.10.2016.
 */

        /*Write a method readNumber(int start, int end), that read from console integer number
        and return it, if it is in the range [start...end].
        If an invalid number or non-number text is read, the method should throw an exception.
        Using this method write a method main(), that has to enter 10 numbers:
        a1, a2, ..., a10, such that 1 < a1 < ... < a10 < 100
*/


public class Task2App {

    public static void main(String[] args) {
        RangeChecker rangeChecker = null;
        try {
             rangeChecker = new RangeChecker();
             //rangeChecker.setStart(500);
            // rangeChecker.setEnd(200);
            for (int i = 0; i < 10; i++) {
                int value = rangeChecker.readNumber();
                System.out.println("value=" + value);
            }
        } catch (InvalidRangeException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rangeChecker != null) {
                rangeChecker.closeScanner();
            }
        }

    }
}
