package homework8.homework.number;

import java.util.Scanner;

/**
 * Created by roma on 31.10.2016.
 */
public class NumberUtils {

    public static int readIntVal(int start, int end) throws NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        String value = null;
        int intRez = 0;
        System.out.print("Enter value(Integer) = ");
        while (scanner.hasNext()) {
            try {
                value = scanner.nextLine().trim();
                if (value.isEmpty()) continue;
                intRez = Integer.parseInt(value);
                if (intRez >= start & intRez <= end) {
                    return intRez;
                } else {
                    System.out.println(value +" does not belong to range ["+start+" : "+end+ "] try again - ");
                }
            } catch (NumberFormatException nfe){
                System.out.println(value +" does not int format try again - ");
            }
        }
        return intRez;
    }

}
