package StatementTask;

import java.util.Scanner;

/**
 * Created by evil on 11.10.16.
 */
public class OddTask {
    public static void main(String[] args) {
        int [] number = new int[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < number.length; i++){
            System.out.println("Input number");
            number[i] = in.nextInt();
        }
        for (int i = 0; i < number.length; i++){
            if (number[i] % 2 != 0) System.out.println("Odd number is " + number[i]);
        }
    }
}
