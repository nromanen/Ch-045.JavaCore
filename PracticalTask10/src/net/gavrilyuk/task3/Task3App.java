package net.gavrilyuk.task3;

import java.io.IOException;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */

      /*Prepare mytext.txt file with a lot of text inside.
        Read context from file into array of strings.
        Each array item contains one line from file.
        Complete next tasks:
        1) count and write the number of symbols in every line.
        2) find the longest and the shortest line.
        3) find and write only that lines, which consist of word «var»*/



public class Task3App {

    private static String consistWord = "test";

    public static void main(String[] args) {

        FileAnalyzer fileAnalyzer = null;
        try {
            fileAnalyzer = new FileAnalyzer("mytext.txt");
            System.out.println("1.Count of the number of symbols in every line:" );
            System.out.println(fileAnalyzer.getCountSymbolInLine());
            System.out.println();
            System.out.println("2.Longest lines:");
            for (String s : fileAnalyzer.getLongestLines()) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println("2.Shortest lines:" );
            for (String s : fileAnalyzer.getShortestLines()) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println("3.Lines which consist of word '" + consistWord + "':");
            for (String s : fileAnalyzer.findLineContainingWord(consistWord)) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileAnalyzer != null) {
                try {
                    fileAnalyzer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
