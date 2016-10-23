package stringandregex.homework.task2;

import util.Scan;

import static util.Print.println;

/*
 * Enter a sentence that contains the words between more than one space.
 * Convert all spaces, consecutive, one.
 * For example, if we introduce the sentence "I    am      learning     Java   Core»,
 * we have to get the "I'm learning Java Core»
 */
public class Main {

    public static void main(String[] args) {
        println("Enter the sentence: ");
        String sentence = Scan.getString(0);
        sentence = Util.removeWhitespaces(sentence);

        Scan.close();

        println(sentence);
    }
}
