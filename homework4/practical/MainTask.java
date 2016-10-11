package homework4.practical;

/**
 *  Created by roma on 08.10.2016.
 *
 *  Create an array of ten integers. Display 
 *  - the biggest of these numbers;
 *  - the sum of positive numbers in the array;
 *  - the amount of negative numbers in the array.
 *  What values there are more: negative or positive?
 */
public class MainTask {

    static int maxPositive = 0;
    static int maxNegative = 0;

    static int sumPositive = 0;
    static int countPositive = 0;

    static int sumNegative = 0;
    static int countNegative = 0;

    public static void main(String[] args){


        int [] array = {23,444,3,0,1,-5,6,-3,-12,4};


        System.out.print("Array: ");
        for(int i=0; i<array.length; i++){
            System.out.print(" " + array[i]);
        }

        // Display - the biggest of these numbers;
        int i = 0;
        while (i<array.length){
            if(array[i]> maxPositive){
                maxPositive = array[i];
            }
            i++;
        }
        System.out.println("\nThe biggest of these numbers: " + maxPositive);

        for (int c = 0; c < array.length; c++) {
            if (maxNegative == 0 && array[c] < maxNegative) {
                maxNegative = array[c];
            } else if (maxNegative < array[c] && array[c] < 0) {
                maxNegative = array[c];
            }
        }
        System.out.println("Max negative number: "+maxNegative);

        //Display
        //  - the sum of positive numbers in the array;
        //  - the amount of negative numbers in the array.
        for (int arr: array){
            if (arr>0){
                sumPositive += arr;
                countPositive++;
            } else {
                sumNegative += arr;
                countNegative++;
            }
        }
        System.out.print("The sum of negative numbers: "+sumNegative +"  values:"+ countNegative);
        System.out.print("\nThe sum of positive numbers: "+ sumPositive +"  values:"+ countPositive);

    }

}
