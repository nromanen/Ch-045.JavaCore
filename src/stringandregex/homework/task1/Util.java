package stringandregex.homework.task1;

import static stringandregex.homework.task2.Util.removeWhitespaces;

public class Util {

    // Method remove two and more whitespaces, trim sentence and return array of words in sentence
    public static String[] toArray(String sentence){
        sentence = removeWhitespaces(sentence);
        sentence = sentence.trim();

        String[] arr = sentence.split(" ");

        return arr;
    }

    // Method return the longest word in the string array
    // (if in array are more than one words with the same quantity of  letters like in the longest word
    // will be return the first one)
    public static String[] getLongestWord(String[] arr) {

        if(arr.length == 1 && arr[0].isEmpty()){
            return null;
        }

        String[] result = {arr[0], String.valueOf(arr[0].length())};

        for (String s : arr) {
            if(s.length() > Integer.parseInt(result[1])){
                result[0] = s;
                result[1] = String.valueOf(s.length());
            }
        }
        return result;
    }

    // Method return the revers representation of word
    public static String revers(String text) {

        char[] charArr = text.toCharArray();

        StringBuilder sb = new StringBuilder("");

        for (int i = charArr.length-1 ; i >= 0; i --) {
            sb.append(charArr[i]);
        }

        return sb.toString();
    }
}
