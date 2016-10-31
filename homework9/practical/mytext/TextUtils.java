package homework9.practical.mytext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 31.10.2016.
 */
public class TextUtils {
    final static String file = "mytext.txt";
    public static List<String> readFile() throws IOException {
        String st = "";
        List list = new ArrayList();
        BufferedReader bufR = new BufferedReader(new FileReader(file));
        while((st = bufR.readLine())!=null) {
            list.add(st);
        }
        return list;
    }
    public static String printLineConsistWord(List<String> list, String word){
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()){
            for (String li: list){
                if (li.contains(word)){
                    sb.append(li+"\n");
                }
            }
            return sb.toString();
        }
        return "Don't find "+word;
    }
    public static String countSymbolNumber(List<String> list){
        StringBuilder sbCount = new StringBuilder();
        if(!list.isEmpty()){
            for (String li: list){
                sbCount.append(li+" ->"+li.length()+"\n");
            }
            return sbCount.toString();
        }
        return "List size = "+list.size();
    }
    public static String findLongestLine(List<String> list){
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
    public static String findShortestLine(List<String> list){
        String shortestLine = "";
        if(list.size()!=0){
            int shortSize = list.get(0).length();
            for(int i=1; i<list.size(); i++){
                if(list.get(i).length() < shortSize){
                    shortSize = list.get(i).length();
                    shortestLine = list.get(i);
                }
            }
            return shortestLine+" - size: "+shortSize;
        }
        return "shortest line don't find";
    }
}
