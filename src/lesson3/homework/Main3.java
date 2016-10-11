package lesson3.homework;

import util.Scan;

import static lesson3.homework.Util.getSumOrProduct;
import static lesson3.homework.Util.positionOfMin;
import static lesson3.homework.Util.positionOfSecondPositive;
import static util.Print.println;


public class Main3 {

    public static  void main (String... args){
        int n = 5;
        println("Enter " + n + " integer numbers");
        int arr[] = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Scan.getInt();
        }

        println("Position of min number is " + positionOfMin(arr));
        println("Position of the secont positive number is " + positionOfSecondPositive(arr));
    }
}

