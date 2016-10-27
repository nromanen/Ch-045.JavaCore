package net.students.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Utils {

    //return true if name matches regex  - else false
    //( enable support  Unicode )
    public static boolean checkName(String name, boolean enableUnicode) {
        Pattern p = Pattern.compile("[a-zA-Z]+", enableUnicode ? Pattern.UNICODE_CHARACTER_CLASS : 0);// 0 - US-ASCII only
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * Returns the string removes spaces, translates to uppercase
     * first letters of the name and surname.
     * @param   s   an {@code String}.
     * @return  a {@code String} string without spaces with the first letter in upper case
     * @throws  java.util.regex.PatternSyntaxException
     */
    public static  String toCapsName(String s) {
        String result="";
        try { //fix
            if (s != null && s.length()>0) {
                String[] words = s.split("\\s");
                for (String w : words) {
                    if (w.length() > 0) {
                        w = w.trim().replaceFirst(String.valueOf(w.trim().charAt(0)),String.valueOf(Character.toUpperCase(w.trim().charAt(0))))+" ";
                        result+=w;
                    }
                }
            }
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        return  result.trim();

    }

    /**
     * Checks whether a character is a number
     * @param   name   an {@code String}.
     * @return  a {@code Boolean} false  - if in name contains the number
     */
    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns true if the string is null or 0-length.
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

}
