package loopsandarrays.practice.task1;

import util.Scan;

import static util.Print.println;

 /*
  * Create an array of ten integers.
  * Display 
  *     the biggest of these numbers;
  *     the sum of positive numbers in the array;
  *     the amount of negative numbers in the array
  * What values there are more: negative or positive?
  */

public class Main {

    public static void main(String... args){


        println("Enter the items of integer array:");
        int[] intArr = new int[10];

        for (int i = 0; i < intArr.length; i++){
            intArr[i] = Scan.getInt();
        }

        println("The biggest number of the array is " + Util.theBiggest(intArr) + ".");
        println("The sum of the positive numbers of the array is " + Util.sumOfPositive(intArr) + ".");
        println("The amount of the negative numbers in array is " + Util.amountOfNegative(intArr) + ". The " + (Util.negativeMore(intArr) ? "negative" : "positive") + " numbers is more.");

        Scan.close();

    }
}
