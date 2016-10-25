package net.gavrilyuk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


}
