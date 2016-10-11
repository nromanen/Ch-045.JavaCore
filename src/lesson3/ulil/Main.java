package lesson3.ulil;

import util.Scan;

import static lesson3.ulil.Util.*;
import static util.Print.print;
import static util.Print.println;

/**
 * Created by Admin on 10.10.16.
 */
public class Main {

    public static void main(String... args){
//        int n = 3;
//        float data [] = new float[n];
//
//
//        print("Enter min of range: ");
//        int min = Scan.getInt();
//        print("Enter max of range: ");
//        int max = Scan.getInt();
//        println("Enter items of array.");
//        for( int i = 0; i < n; i++){
//            data[i] = Scan.getFloat();
//        }
//        if (inRange(min, max, data)){
//            println("All numbers is in range [" + min + ", " + max + "].");
//        } else {
//            println("Not all numbers is in range [" + min + ", " + max + "].");
//        }
//
//        println("Enter 3 integers:");
//        int a = Scan.getInt();
//        int b = Scan.getInt();
//        int c = Scan.getInt();
//
//        println("Max of this numbers is: " + maxOfThreInt(a, b, c));

        println("Enter the items of integer array:");
        int[] intArr = new int[10];

        for (int i = 0; i < intArr.length; i++){
            intArr[i] = Scan.getInt();
        }

        println("The biggest number of the array is " + theBiggest(intArr) + ".");
        println("The sum of the positive numbers of the array is " + sumOfPositive(intArr) + ".");
        println("The amount of the negative numbers in array is " + amountOfNegative(intArr) + ". The " + (negativeMore(intArr) ? "negative" : "positive") + "is more.");

        Scan.close();

    }
}
