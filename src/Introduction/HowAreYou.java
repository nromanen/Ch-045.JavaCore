package introduction;

import static introduction.Calc.println;
import static introduction.Scan.getString;

/**
 * Created by Ariezz on 28.09.16.
 */
public class HowAreYou {

    public static void main(String ... args){

        println("How are you?");
        String answer = getString(1);
        println("You are ", answer, "!");

        Scan.scanner.close();
    }


}
