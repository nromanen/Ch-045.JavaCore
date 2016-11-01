package net.gavrilyuk.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class ResumeFileConverter {

    private String dataFile;
    private String outputFile;
    private List<String> data;
    private Resume resume;

    public ResumeFileConverter() {
        data = new ArrayList<>();
    }

    public ResumeFileConverter(String dataFile, String outputFile) {
        this();
        this.dataFile = dataFile;
        this.outputFile = outputFile;
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public List<String> getData() {
        return data;
    }

    //number of lines in dataFile.
    public int getLinesCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }
    // longest line in dataFile
    public String getLongestLine() {
        if (data != null && data.size()>0) {
            String longestLine = null;
            int longSize = data.get(0).length();
            for (String line : data) {
                if (line.length() > longSize) {
                    longSize = line.length();
                    longestLine = line;
                }
            }
            System.out.println("longset="+longestLine);
            return longestLine;
        }
        return null;
    }
    //your name and birthday date
    public void writeDataToTxtFile() throws IOException {
        if (outputFile != null) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            fw = new FileWriter(outputFile);
            bw = new BufferedWriter(fw);
            bw.write(getLinesCount()+"\n");//number of lines in dataFile.
            bw.write(getLongestLine()+"\n");  // longest line in dataFile
            bw.write(resume.getName()+"\n");  // //your name
            bw.write(resume.getDateOfBirth().toString()+"\n");  // //your birthday date
            bw.close();
            fw.close();
        } else {
            throw new IOException("output txt file name not set!");
        }

    }

   public void writeDataToFile(Resume resume) throws IOException {
       if (dataFile != null) {
           FileOutputStream fout = new FileOutputStream(dataFile);
           ObjectOutputStream oos = new ObjectOutputStream(fout);
           oos.writeObject(resume);
           oos.close();
       } else throw new IOException("dataFile name not set!");
   }

 public Resume readDataFromFile() throws IOException, ClassNotFoundException {
     Resume r;
     if (dataFile != null) {
     FileInputStream fin = new FileInputStream(dataFile);
     ObjectInputStream ois = new ObjectInputStream(fin);
     r = (Resume) ois.readObject();
     ois.close();
     } else throw new IOException("dataFile name not set!");
     resume = r;
     if (data != null) {
         data.add(r.getName());
         data.add(r.getDateOfBirth().toString());
         for (String s : Arrays.asList(r.getCareer().split("\\n"))) {
             data.add(s);
         }
     }
     return r;
 }

}
