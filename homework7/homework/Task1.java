package homework7.homework;

import java.util.List;

/**
 * Created by roma on 22.10.2016.
 * Enter in the console sentence of five words.
        display the longest word in the sentence
        determine the number of its letters
        bring the second word in reverse order
 */
public class Task1 {
    public static void main(String[] args){

        String str = "last implementations quantifier in homework7 expressions corresponds to the maximum";
        String[] sentences = Util.listWords(str);

        //Display longest world and its number letters
        System.out.println(Util.displayLongestWord(sentences));

        //Display reverse world
        int numberReverseWorld = 7;
        System.out.println(Util.wordReverse(sentences, numberReverseWorld));
    }
}
