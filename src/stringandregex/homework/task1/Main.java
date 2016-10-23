package stringandregex.homework.task1;

import util.Scan;

import static stringandregex.homework.task1.Util.getLongestWord;
import static stringandregex.homework.task1.Util.revers;
import static stringandregex.homework.task1.Util.toArray;
import static util.Print.print;
import static util.Print.println;

/*
 * Enter in the console sentence of five words.
 *      - display the longest word in the sentence
 *      - determine the number of its letters
 *      - bring the second word in reverse order
 */
public class Main {

    public static void main(String[] args) {
        println("Enter the sentence!");
        String sentence = Scan.getString(-8);
        Scan.close();

        try {
            println("The longest word is \"", getLongestWord(toArray(sentence))[0], "\" and it has ",
                    getLongestWord(toArray(sentence))[1], " letters.");
        } catch (NullPointerException e){
            println("Error. Empty sentence!");
            return;
        }
        println();

        try {
            println("The second word in the sentence is \"", toArray(sentence)[1], "\" and in the revers order it will be \"", revers(toArray(sentence)[1]), "\".");
        } catch (ArrayIndexOutOfBoundsException e){
            println("Can't display revers representation of second word in this sentence. In this sentence is less than two words.");
        }

    }
}
