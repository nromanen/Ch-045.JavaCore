package net.gavrilyuk;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * Created by GipSoft on 18.10.2016.
 */
public class StringsUtils {


    //Task 1

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    //Task 2

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

    /**
     * Checks whether a character is a number
     * @param   name   an {@code String}.
     * @return  a {@code Boolean} false  - if in name contains the number
     * @throws  IllegalArgumentException
     */
    public static boolean isAlpha(String name) throws IllegalArgumentException {
        char[] chars = name.toCharArray();
        if (chars.length == 0) throw new IllegalArgumentException("Name should not be empty!");
        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the string removes spaces, translates to uppercase
     * first letters of the name and surname.
     * @param   s   an {@code String}.
     * @return  a {@code String} string without spaces with the first letter in upper case
     * @throws  java.util.regex.PatternSyntaxException
     */
    public static  String toCapsWord(String s)  {
        String result="";
        try {
            if (s != null && s.length()>0) {
                String[] words = s.split("\\s");
                for (String w : words) {
                    if (w.length() > 0) {
                        w = w.trim().replaceFirst(String.valueOf(w.trim().charAt(0)),
                                String.valueOf(Character.toUpperCase(w.trim().charAt(0))))+" ";
                        result+=w;
                    }
                }
            }
        } catch (PatternSyntaxException e) {
            //e.printStackTrace();
        }
        return  result.trim();

    }

    //For Task3

    //return true if userName matches regex
    public static boolean checkUserName(String userName) {
        //Pattern p =Pattern.compile("^[\\w]{3,15}$");
        //return p.matcher(userName).matches();
        return checkUserName(userName, false);
    }

    //return true if userName matches regex  - else false
    //( enable support  Unicode )
    public static boolean checkUserName(String userName, boolean enableUnicode) {
        //^- the beginning of a line
        // \w	a word character: [a-zA-Z_0-9]
        // X{n,m}    X, at least n but not more than m times
        // $- the end of a line
        //Pattern.UNICODE_CHARACTER_CLASS - Enables the Unicode version of Predefined character classes and POSIX character classes.
        Pattern p = Pattern.compile("^[\\w]{3,15}$", enableUnicode ? Pattern.UNICODE_CHARACTER_CLASS : 0);// 0 - US-ASCII only
        Matcher m = p.matcher(userName);
        return m.matches();
    }

}
