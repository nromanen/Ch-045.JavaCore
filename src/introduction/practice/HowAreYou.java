package introduction.practice;

import util.Scan;

import static util.Print.println;
import static util.Scan.getString;

 /*
  * Output question “How are you?“. Define string variable answer.
  * Read the value answer and output: “You are (answer)".
  */
public class HowAreYou {

    public static void main(String ... args){

        println("How are you?");
        String answer = getString(1);
        println("You are ", answer, "!");

        Scan.close();
    }


}
