package net.gavrilyuk.employee;

import java.util.regex.PatternSyntaxException;

/**
 * Employee Util Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeUtil {

    /**
     * Returns the string removes spaces, translates to uppercase
     * first letters of the name and surname.
     * @param   s   an {@code String}.
     * @return  a {@code String} string without spaces with the first letter in upper case
     * @throws  java.util.regex.PatternSyntaxException
     */
    public static  String toCapsWord(String s) {
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

}
