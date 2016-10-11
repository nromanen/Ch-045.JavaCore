package StatementWork;

/**
 * Created by evil on 11.10.16.
 */
public class AppMain {
    public static void main(String[] args) {
        //check float number
        float num1 = Number.readFloatNumber();
        float num2 = Number.readFloatNumber();
        float num3 = Number.readFloatNumber();
        if (Number.checkFloatNumber(num1, num2, num3)){
            System.out.println("Number is between -5 5");
        } else System.out.println("Number is not between -5 5");
    }
}
