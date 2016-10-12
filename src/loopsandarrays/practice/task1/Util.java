package loopsandarrays.practice.task1;

import java.util.Arrays;

public class Util {

    // Method return the biggest number of the array
    public static int theBiggest(int[] arr){
        Arrays.sort(arr);
        return  arr[arr.length-1];
    }

    // Method return the sum of positive numbers of the arra
    public static int sumOfPositive(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                sum += arr[i];
            }
        }
        return sum;
    }

    // Method return amount of negative numbers in array
    public static int amountOfNegative(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                result++;
            }
        }
        return result;
    }

    // Method check are the negative numbers more than the positive ones
    public static boolean negativeMore(int[] arr){
        return amountOfNegative(arr) > (arr.length - amountOfNegative(arr));
    }
}
