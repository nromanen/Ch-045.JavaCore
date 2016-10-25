package homework7.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roma on 23.10.2016.
 */
public class Util {

    public static final String PATTERN_SENTENCES = "[\\w\\s]+(\\w)?";
    public static final String PATTERN_US_CURRENCY = "(\\$\\d+\\.\\d{2})|(\\$\\d*)";
    //public static final String PATTERN_US_CURRENCY = "(\\$[1-9]+\\.[0-9]{2})|(\\$[0-9]+)";

    //return reverse of word
    public static String wordReverse(String [] listWorld, int numberWorld){
        int searchWorld = numberWorld - 1;
        if( (searchWorld <= listWorld.length) & (searchWorld >= 0) ){
            StringBuilder sBuilder = new StringBuilder(listWorld[searchWorld]);
            sBuilder.reverse();
            return "Reverse world "+(numberWorld)+" - "+sBuilder.toString();
        }
        return "World at its number does not exists! ";
    }
    //forming List<String> of words from a given sentence
    public static String [] listWords(String sentences){
        String result = sentences.trim();
        String[] listWorlds = null;
        if (!result.isEmpty()&isSentenceMatches(result, PATTERN_SENTENCES) ){
            listWorlds = result.split(" ");
        }
        return listWorlds;
    }
    //return longest word from List and its length
    public static String displayLongestWord(String[] listSentences){
        StringBuilder sBuilder = new StringBuilder();
        String longestWord = listSentences[0];

        for (int i=1; i<listSentences.length; i++){
            if (listSentences[i].length()>longestWord.length()){
                longestWord = listSentences[i];
            }
        }
       sBuilder.append("Longest world - ").append(longestWord)
                .append(" number of letters - ").append(longestWord.length());
        return sBuilder.toString();
    }

    //isSentenceMatches(String sentence, String pattern)
    public static boolean isSentenceMatches(String sentence, String pattern){
        //String pattern = "[\\w\\s]+(\\w)?";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(sentence);
        return m.matches();
    }

    //Convert all space to one
    public static String replaceAllSpace(String sentence){
        sentence = sentence.trim();
        sentence = sentence.replaceAll("[\\s]+"," ");
        return sentence;
    }
    //Display all occurrences of US currency
    public static String displayAllOccurrenceUS(String text){
        Pattern p = Pattern.compile(PATTERN_US_CURRENCY);
        Matcher m = p.matcher(text);
        StringBuilder sb = new StringBuilder();
        while(m.find()){
            sb.append(m.group()).append("\n");
        }
        return sb.toString();
    }
}
