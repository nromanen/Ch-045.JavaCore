package lesson3.odd;

import util.Scan;

import static util.Print.println;

/**
 * Created by Admin on 10.10.16.
 */
public class Main {

    public static void main(String... args){

        int n = 3;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println(AreOdd.howManyOdd(arr));
    }
}
