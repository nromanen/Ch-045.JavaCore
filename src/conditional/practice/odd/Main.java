package conditional.practice.odd;

import util.Scan;

import static util.Print.println;

/*
 * Enter three numbers. Find out how many of them are odd.
 */

public class Main {

    public static void main(String... args){

        int n = 3;

        println("Enter ", n, " numbers: ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println("You entered ", Odd.howManyOdd(arr), " odd numbers!");
    }
}
