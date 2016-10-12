package loopsandarrays.homework.tasks;

import util.Scan;

import static util.Print.println;

 /*
  * Enter 10 integer numbers.
  * Calculate the sum of first 5 elements if they are positive or product of last 5 element in the other case.
  */
public class Main2 {

    public static  void main (String... args){

        int n = 10;
        println("Enter " + n + " integer numbers");
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println("Result is " + Util.getSumOrProduct(arr));

        Scan.close();
    }
}

