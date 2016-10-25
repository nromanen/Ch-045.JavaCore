package net.gavrilyuk;

import java.util.*;
import java.util.regex.PatternSyntaxException;

/**
 *
 * Created by Igor Gavryliuk on 20.10.2016.
 */

        /*Enter in the console sentence of five words.
        1.display the longest word in the sentence
        2.determine the number of its letters
        3.bring the second word in reverse order*/

public class Task1App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = StringsUtil.readString(scanner, "Enter sentence of five words:");
      //  String sentence ="    word1 word12 word1234 w  word123456  word12315                                67890                ";
        try {
            sentence = StringsUtil.removeSpaces(sentence);
            String[] words = Arrays.copyOfRange(sentence.split("\\s"), 0, 5); // get first 5
            System.out.println(Arrays.toString(words));//print
            System.out.println("Longest word=" + StringsUtil.longestWord(words));
            System.out.println("Total letter count=" + StringsUtil.countLetters(words));
            System.out.println("Second word in reverse order=" + StringsUtil.reverseString(words[1]));
            System.out.println("The frequency of the use of symbols:" + StringsUtil.frequencyUseSymbols(sentence));
        } catch (IndexOutOfBoundsException | PatternSyntaxException | NullPointerException e) {
            System.out.println(e);
        }
        scanner.close();
    }

}
