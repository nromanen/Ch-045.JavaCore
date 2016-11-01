package homework9.homework.myfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 31.10.2016.
 */
public class Utils {

    static List<String> list = new ArrayList<>();

    public static List<String> readFile(String file) throws FileNotFoundException {
        String st = "";
        BufferedReader bufR = new BufferedReader(new FileReader(file));
        try {
            while((st = bufR.readLine())!=null) {
                list.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void writeListToFile(List<String> newList, String file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        for (String li: newList){
            out.writeBytes(li + "\n");
        }
        //out.writeObject(newList);
        out.close();
    }
    public static int getNumberLinesFile(String file) {
        if (list.isEmpty()){
            try {
                readFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        if (list.size()!=0){
            for(String li: list){
                count++;
            }
        }
        return count;
    }
    public static String findLongestLine(String file){
        if (list.isEmpty()){
            try {
                readFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String longestLine = "";
        if(list.size()!=0){
            int longestSize = list.get(0).length();
            for (int i=1; i<list.size(); i++){
                if(list.get(i).length()>longestSize){
                    longestSize = list.get(i).length();
                    longestLine = list.get(i);
                }
            }
            return longestLine+" - size: "+longestSize;
        }
        return "longest line don't find, list size = "+list.size();
    }
}
