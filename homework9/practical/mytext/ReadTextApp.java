package homework9.practical.mytext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 30.10.2016.
 * Prepare mytext.txt file with a lot of text inside.
 Read context from file into array of strings.
 Each array item contains one line from file.
 Complete next tasks:
 1) count and write the number of symbols in every line.
 2) find the longest and the shortest line.
 3) find and write only that lines, which consist of word «var»

 */
public class ReadTextApp {
    final static String word = "var";
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList();
        try {
            arrayList = TextUtils.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        System.out.println(TextUtils.printLineConsistWord(arrayList, word));
        //
        System.out.println(TextUtils.countSymbolNumber(arrayList));
        //
        System.out.println(TextUtils.findLongestLine(arrayList));
        //
        System.out.println(TextUtils.findShortestLine(arrayList));
    }
}
