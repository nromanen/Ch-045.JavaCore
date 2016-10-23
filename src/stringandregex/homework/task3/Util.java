package stringandregex.homework.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    // Method return array of all currency in the text
    public static List<String> getCurrency(String text) {

        String pattern = "\\$\\d+.\\d{2}";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        List<String> resultList = new ArrayList<>();

        while (m.find()){
            resultList.add(text.substring(m.start(), m.end()));
        }

        return resultList;
    }
}
