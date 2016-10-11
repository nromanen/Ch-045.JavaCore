package homework4.homework;

import java.util.Scanner;

/**
 * Created by roma on 10.10.2016.
 *
 * Ask user to enter the number of month.
 * Read the value and write the amount of days in this month (create array with amount days of each month).

 * Enter 10 integer numbers.
    * Calculate the sum of first 5 elements if they are positive or product of last 5 element in the other case.

 * Enter 5 integer numbers.Find
    * position of second positive number;
    * minimum and its position in the array.

 * Organize entering integers until the first negative number. Count the product of all entered even numbers.

 */
public class MainTask {
    static int [] array = {1,1,-1,1,1,7,8,9,7,3};

    public static void main(String[] args){

        //Ask user to enter the number of month.
        // Read the value and write the amount of days in this month (create array with amount days of each month).

        MainTask mainTask =new MainTask();

        System.out.println(mainTask.amountDay(5));

        // Enter 10 integer number.
        //  Calculate the sum of first 5 elements if they are positive or product of last 5 element in the other case.

        int [] number ={5,3,2,1,1,2,-8,6,5,4};

        if(number[0] > 0 & number[1] > 0 & number[2] > 0 & number[3] > 0 & number[4] > 0){
            int sum = number[0] + number[1] + number[2] + number[3] + number[4];
            System.out.println("First 5 elements of array are positive, their sum = " + sum);
        } else{
            int prod = number[5] * number[6] * number[7] * number[8] * number[9];
            System.out.println("Not all first 5 elements of array are positive, production of last 5 element = " + prod);
        }

        // Enter 5 integer number.Find
        //    position of second positive number;
        //    minimum and its position in the array.

        int [] array5 = {-5,1,2,3,-8};
        int count = 0;
        int secondPosNum = 0;

        for (int i=0; i<array5.length; i++){
            if ( array5[i]>0 ){
                count++;
                if(count == 2){
                    secondPosNum = i;
                    System.out.println("Position of second positive number: " + secondPosNum);
                    break;
                }
            }
        }

        //Organize entering integers until the first negative number.
        // Count the product of all entered even numbers.

        Scanner scan = new Scanner(System.in);
        int next;
        boolean close = true;
        do {
            System.out.print("Enter number: ");
            next = scan.nextInt();
            if (next < 0){ break;}
        }
        while(close);
    }

    public int amountDay(int monthNumber ){
        int [] arrDayMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
        for(int i=0; i<arrDayMonth.length; i++){
            if ((i+1) == monthNumber){
                return arrDayMonth[i];
            }
        }
        return 0;
    }

}
