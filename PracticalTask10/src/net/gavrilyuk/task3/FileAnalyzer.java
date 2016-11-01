package net.gavrilyuk.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text File Analyzer Class
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class FileAnalyzer extends BufferedReader {

    List<String> lines;
    String fileName;

    public FileAnalyzer(String file) throws IOException {
        super(new FileReader(file));
        lines = new ArrayList<>();
        this.fileName = file;
        fillInFile();
    }

    public List<String> getLines() {
        return lines;
    }

    public String getFileName() {
        return fileName;
    }
    //read data from a file
    private   List<String> fillInFile() throws IOException {
        String st;
        while ((st = readLine()) != null) {
            lines.add(st);
        }
        return lines;
    }

    // count and write the number of symbols in every line.
    public String getCountSymbolInLine(){
        StringBuilder result = new StringBuilder();
        if(lines!=null && !lines.isEmpty()){
            for (String s: lines){
                result.append("'").append(s).append("'").append(" [length:").append(s.length()).append("]").append("\n");
            }
            return result.toString();
        }
        return "Empty file";
    }

    //find the longest line.
    private String findLongestLine(){
        if(lines!=null && lines.size()>0){
            String longestLine = null;
            int longSize = lines.get(0).length();
            for (String line : lines) {
                if (line.length() > longSize) {
                    longSize = line.length();
                    longestLine = line;
                }
            }
            return longestLine;
        }
        return null;
    }

    // find  the shortest line.
    private  String findShortestLine() {
        if (lines != null && lines.size() > 0) {
            String shortestLine = null;
            int shortSize = lines.get(0).length();
            for (String line : lines) {
                if (line.length() < shortSize && !line.isEmpty()) {
                    shortSize = line.length();
                    shortestLine = line;
                }
            }
            return shortestLine;
        }
        return null;
    }

    // get list of the shortest line(s).
    public List<String> getShortestLines() {
        List<String> result = new ArrayList<>();
        String shortestLines = findShortestLine();
        if (shortestLines != null) {
            for (String line : lines) {
                if (line.equals(shortestLines))
                  result.add(line);
            }
        }
        return result;
    }

    // get list of the longest line(s).
    public List<String> getLongestLines() {
        List<String> result = new ArrayList<>();
        String longestLine = findLongestLine();
        if (longestLine != null) {
            for (String line : lines) {
                if (line.equals(longestLine))
                    result.add(line);
            }
        }
        return result;
    }

    // find and write only that lines, which consist of word «var»
    public List<String> findLineContainingWord(String searchWord) {
        List<String> result = new ArrayList<>();
        if (lines!=null && lines.size()>0) {
            for (String line : lines) {
                if (line.contains(searchWord)) {
                    result.add(line);
                }
            }
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        super.close();
        if (lines != null) {
            lines.clear();
        }
    }
}
