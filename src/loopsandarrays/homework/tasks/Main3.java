package loopsandarrays.homework.tasks;

import util.Scan;

import static util.Print.println;

 /*
  * Enter 5 integer numbers. Find
  *     position of second positive number;
  *     minimum and its position in the array.
  */

public class Main3 {

    public static  void main (String... args){
        int n = 5;
        println("Enter " + n + " integer numbers");
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println("Min number is ", Util.positionOfMin(arr)[0], ". Position of min number is ", Util.positionOfMin(arr)[1]);
        println("Position of the second positive number is " + Util.positionOfSecondPositive(arr));
    }
}

