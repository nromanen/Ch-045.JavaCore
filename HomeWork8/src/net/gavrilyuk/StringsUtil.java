package net.gavrilyuk;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by GipSoft on 18.10.2016.
 */
public class StringsUtil {

    //For All tasks
    public static String readString(Scanner scanner, String query) {
        String line = null;
        System.out.print(query);
        while (scanner.hasNext()) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            if (line.length() > 0) {
                break;
            } else {
                System.out.println("value must be not empty!");
                System.out.print(query);
            }

        }
        return line;
    }


    //For Task1


    // return reverse string
    public static String reverseString(String source) {
        return new StringBuilder(source).reverse().toString();
    }

    // return count letters of the array of words
    public static int countLetters(String[] source) {
        StringBuilder builder = new StringBuilder();
        for (String s : source) {
            builder.append(s);
        }
        return builder.length();
    }
    // return count unique letters of the array of words
    public static Map<Character,Integer> countUniqueLetters(String[] source) {
        Map<Character,Integer> result = new HashMap<>();
        for (String s : source) {
            for (Character c : s.toCharArray()) {
                int count =0;
                if (result.containsKey(c)) {
                    count++;
                } else count =1;
                result.put(c, count);
            }
        }
        return result;
    }

    //return longest word
    public static String longestWord(String[] words) throws NullPointerException{
        List<String> list = Arrays.asList(words);//convert array to list
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (null != o1 && null != o2) {
                    return o1.compareToIgnoreCase(o2);
                } else throw new NullPointerException("String must be not null!");

            }
        };
        return Collections.max(list, comparator);
    }

    //For Task 2

    //Convert all spaces, consecutive, one
    public static String removeSpaces(String source) throws NullPointerException {
        if (source != null) {
            return source.replaceAll("\\s{2,}", "\\s").trim();
        } else throw new NullPointerException("String can not be null!");

    }

    //For Task 3

    //return strings of occurrences of source matches regex
    public static String checkRegExp(String source) {
        Pattern p = Pattern.compile("\\$(\\d*)(\\.\\d{2,2})");//variant1
       // Pattern p = Pattern.compile("[$](([1-9]+\\.?\\d*)|([0]\\.\\d*)|[0])");////variant2
        Matcher m = p.matcher(source);
        StringBuilder result = new StringBuilder();
        // Find all matches
        while (m.find()) {
            // Get the matching string
            result.append(m.group()).append("  ");
        }
        return result.toString();
    }

}
