package stringandregex.practice.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    // Method check the name is from 3 to 15 characters of the Latin alphabet, numbers, and underscores.
    // The name can have 2 parts like describe, between parts of name must be "-".
    public static boolean isCorrectName(String s){

        String pattern = "[A-Z]{1}[_a-z0-9]{2,14}(-([A-Z]{1}[_a-z0-9]{2,14}){1})?";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        return m.matches();
    }
}
