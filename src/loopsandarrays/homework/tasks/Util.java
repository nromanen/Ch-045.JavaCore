package loopsandarrays.homework.tasks;

import java.util.ArrayList;

public class Util {

    // Method return amount of days in month by it number
    public static int getDaysAmount(int month){

        int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month >= 1 && month <= days.length){
            return days[month - 1];
        } else {
            return -1;
        }
    }

    // Method calculates the sum of first 5 elements if they are positive or product of last 5 element in the other case.
    public static int getSumOrProduct(int[] arr){
        int result = 0;
        boolean ispPositive = true;
        for(int i = 0; i < 5; i++){
            if (arr[i] > 0){
                result += arr[i];
            } else {
                ispPositive = false;
                break;
            }
        }
        if (ispPositive){
            return result;
        } else {
            result = 1;
            for(int i = 5; i < 9; i++){

                    result *= arr[i];
            }
        }

        return result;

    }

    // Method returns min number in array and i position
    public static int[] positionOfMin (int[] arr){

        int min = arr[0];
        int position = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
                position = i;
            }
        }
        int [] result = {
                min,
                position + 1
        };
        return result;
    }

    // Method returns position of second positive number;
    public static int positionOfSecondPositive (int[] arr){

        int count = 0;
        int position = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 0){
                count ++;
                position = i;
            }
            if (count == 2){
                break;
            }
        }

        return position + 1;
    }

    // Method returns product of all even number in lost
    public static int product(ArrayList<Integer> list){
        int result = 1;

        for (int i = 1; i < list.size(); i+=2){
            result *= list.get(i);
        }
        return result;
    }
}
