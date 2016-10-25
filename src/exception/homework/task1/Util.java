package exception.homework.task1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    // Method read two double numbers d1 and d2 and return divide d1/d2
    public static double div() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double d1 = 0.0;
        Double d2 = 0.0;
        try {
            d1 = Double.parseDouble(br.readLine());
            d2 = Double.parseDouble(br.readLine());
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        if (d2 == 0){
            throw new ArithmeticException("Divide by zero");
        }

        br.close();
        return d1/d2 ;
    }
}
