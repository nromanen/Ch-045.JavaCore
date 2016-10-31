package homework8.practical.rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by roma on 31.10.2016.
 */
public class Utils {
    public static int readIntVal(String value){
        Scanner scanner = new Scanner(System.in);
        String intVal = null;
        int intRez = 0;
        System.out.print("Enter value(Integer) " + value + " = ");
        while (scanner.hasNext()) {
            try{
                intVal = scanner.nextLine().trim();
                if (intVal.isEmpty()) continue;
                intRez = Integer.parseInt(intVal);
                if (intRez > 0 ) {
                    return intRez;
                } else {
                    System.out.print(intVal + ": not correct try again - " );
                }
            } catch (NumberFormatException nfe){
                System.out.print(intVal + ": not correct try again - " );
            }
        }
        return intRez;
    }
}
