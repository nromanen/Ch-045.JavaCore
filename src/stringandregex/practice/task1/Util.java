package stringandregex.practice.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    // Method check is first string (s1) substring of second string (s2)
    public static boolean contains(String s1, String s2){

        if(s2.length() < s1.length()){
            return false;
        }

        Pattern p = Pattern.compile(s1);
        Matcher m = p.matcher(s2);

        return m.find();
    }
}
