package ArrayTenInteger;


import java.util.Random;

/**
 * Created by evil on 19.10.16.
 */

    /*Create an array of ten integers. Display 
    the biggest of these numbers;
    the sum of positive numbers in the array;
    the amount of negative numbers in the array.
    What values there are more: negative or positive?
    */
public class TenInteger<T> {
    public static void main(String[] args) {
        int [] tenInteger = new int[10];
        Random k = new Random();
        for (int i = 0; i < tenInteger.length; i++ ){
            tenInteger[i] = k.nextInt(21) - 10;
        }

        for (int i = 0; i < tenInteger.length; i++){
            System.out.println("Number is " + tenInteger[i]);
        }
        int max = tenInteger[0];
        int amountOfNonPositive = 0;
        int sumOfPositive = 0;
        int positive = 0;
        for (int i = 0; i < tenInteger.length; i++){
            if (tenInteger[i] > max) max = tenInteger[i];
            if (tenInteger[i] > 0) {
                sumOfPositive+= tenInteger[i];
                positive++;
            }
            if (tenInteger[i] < 0) amountOfNonPositive++;
        }
        System.out.println("Max number = " + max
                            + " amount of non positive = " + amountOfNonPositive
                            + " sum of positive = " + sumOfPositive);
        if (amountOfNonPositive > positive){
            System.out.println("More negative numbers");
        } else System.out.println("More positive number");
    }
}
