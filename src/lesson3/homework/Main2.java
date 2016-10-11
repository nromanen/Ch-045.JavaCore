package lesson3.homework;

import util.Scan;

import static lesson3.homework.Util.getSumOrProduct;
import static util.Print.println;

public class Main2 {

    public static  void main (String... args){

        int n = 10;
        println("Enter " + n + " integer numbers");
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println("Result is " + getSumOrProduct(arr));

        Scan.close();
    }
}
