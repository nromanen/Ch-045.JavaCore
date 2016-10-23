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

    //return reverse of word
    public static String wordReverse(List<String> listWorld, int numberWorld){
        int searchWorld = numberWorld - 1;
        if( (searchWorld <= listWorld.size()) & (searchWorld >= 0) ){
            StringBuilder sBuilder = new StringBuilder(listWorld.get(searchWorld));
            sBuilder.reverse();
            return "Reverse world "+(numberWorld)+" - "+sBuilder.toString();
        }
        return "World at its number does not exists! ";
    }
    //forming List<String> of words from a given sentence
    public static List<String> listWords(String sentences){
        String result = sentences.trim();
        List<String> listWorlds = null;
        if (!result.isEmpty()&isValidSentence(result) ){
            listWorlds = Arrays.asList(result.split(" "));
        }
        return listWorlds;
    }
    //return longest word from List and its length
    public static String displayLongestWord(List<String> listSentences){
        StringBuilder sBuilder = new StringBuilder();
        String longestWord = Collections.max(listSentences, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        sBuilder.append("Longest world - ").append(longestWord)
                .append(" number of letters - ").append(longestWord.length());
        return sBuilder.toString();
    }


    public static boolean isValidSentence(String sentence){
        String pattern = "[\\w\\s]+(\\w)?";
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
        String pattern = "(\\$\\d+\\.\\d{2})|(\\$\\d*)";
        //String pattern = "(\\$[1-9]+\\.[0-9]{2})|(\\$[0-9]+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        StringBuilder sb = new StringBuilder();
        while(m.find()){
            sb.append(m.group()).append("\n");
        }
        return sb.toString();
    }
}
