package net.gavrilyuk.person;

/**
 *
 * Created by Igor Gavryliuk on 29.09.2016.
 */
public class TxtUtil {

    public static  String toCapsFirstLetter(String s) {
        String result="";
        if (s != null && s.length()>0) {
            String[] words = s.split("\\s");
            for (String w : words) {
                if (w.length() > 0) {
                    w = w.trim().replaceFirst(String.valueOf(w.trim().charAt(0)),String.valueOf(Character.toUpperCase(w.trim().charAt(0))))+" ";
                    result+=w;
                }
            }
        }
        return  result.trim();
    }
}
