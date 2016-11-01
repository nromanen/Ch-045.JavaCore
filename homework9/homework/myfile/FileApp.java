package homework9.homework.myfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 31.10.2016.
 * Create file1.txt file with a text about your career.
 Read context from file into array of strings. Each array item contains one line from file.
 Write in to the file2.txt
 1) number of lines in file1.txt.
 2) the longest line in file1.txt.
 3) your name and birthday date.

 */
public class FileApp {

    final static String file1 = "file1.txt";
    final static String file2 = "file2.txt";
    final static String name = "Name1";
    final static String dateOfBirth = "17/02/1985";

    public static void main(String[] args){

        //get number of lines in file1.txt
        int number = Utils.getNumberLinesFile(file1);
        //get the longest line in file1.txt
        String longestLine = Utils.findLongestLine(file1);

        //form List to write in file2
        List<String> newList = new ArrayList<>();
        newList.add("Number of lines"+String.valueOf(number));
        newList.add(longestLine);
        newList.add(name+" "+dateOfBirth);

        try {
            //write List newList to file2.txt
            Utils.writeListToFile(newList,file2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
