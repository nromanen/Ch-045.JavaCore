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
}
