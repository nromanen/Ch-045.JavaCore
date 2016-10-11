package lesson3.ulil;

import java.util.Arrays;

/**
 * Created by Admin on 10.10.16.
 */
public class Util {
    public static boolean inRange(int min, int max, float... data){

        if (max < min) {
            return false;
        }

        boolean isInRange = true;

        for (Float f: data){
            if(f >= min && f <= max){
                continue;
            } else {
                isInRange = false;
            }
        }

        return isInRange;
    }

    public static int maxOfThreInt(int a, int b, int c){
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max){
            max = c;
        }
        return max;
    }

    public static int theBiggest(int[] arr){
        Arrays.sort(arr);
        return  arr[arr.length-1];
    }

    public static int sumOfPositive(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                sum += arr[i];
            }
        }
        return sum;
    }

    public static int amountOfNegative(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                result++;
            }
        }
        return result;
    }

    public static boolean negativeMore(int[] arr){
        return amountOfNegative(arr) > (arr.length - amountOfNegative(arr));
    }
}
