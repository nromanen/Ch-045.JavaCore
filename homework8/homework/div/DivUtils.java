package homework8.homework.div;

import java.util.Scanner;

/**
 * Created by roma on 31.10.2016.
 */
public class DivUtils {

    public static double readDoubleVal(){
        Scanner scanner = new Scanner(System.in);
        String doubleVal = null;
        double doubleRez = 0;
        System.out.print("Enter value(Double) = ");
        while (scanner.hasNext()) {
            try{
                doubleVal = scanner.nextLine().trim();
                if (doubleVal.isEmpty()) continue;
                doubleRez = Double.parseDouble(doubleVal);
                if (doubleRez != 0 ) {
                    return doubleRez;
                } else {
                    System.out.print(doubleVal + ": not correct try again - " );
                }
            } catch (NumberFormatException nfe){
                System.out.print(doubleVal + ": not correct try again - " );
            }
        }
        return doubleRez;
    }

    public static double getDiv(double a, double b)throws ArithmeticException{
        if (b == 0) throw new ArithmeticException("Div by zero");
        return a/b;
    }
}
