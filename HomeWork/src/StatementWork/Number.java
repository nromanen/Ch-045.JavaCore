package StatementWork;
import java.util.Scanner;

/**
 * Created by evil on 11.10.16.
 */
public class Number {

    public static float readFloatNumber(){
        Scanner in = new Scanner(System.in);
        float num;
        System.out.println("Print float number");
        num = in.nextFloat();
        return num;
    }

    public static boolean checkFloatNumber(float num1, float num2, float num3){
        float [] floatArray = {num1, num2, num3};
        for (int i = 0; i < floatArray.length; i++){
            if (!(floatArray[i] >= -5 && floatArray[i] <=5)) return false;
        }
        return true;
    }

    public static int readIntNumber(){
        Scanner in = new Scanner(System.in);
        System.out.println("Print integer number");
        int num = in.nextInt();
        return num;
    }

    public static void findMinMaxInt (int num1, int num2, int num3){
        int [] number = {num1, num2, num3};
        int max = number[0];
        int min = number[0];
        for (int i = 0; i < number.length; i++){
            if (number[i] > max) max = number[i];
            if (number[i] < min) min = number[i];
        }
        System.out.println("Min number is " + min
                            + " max number is " + max);
    }
}
