package net.gavrilyuk.task4;

import java.io.IOException;
import java.sql.Date;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
      /*  Create file1.txt file with a text about your career.
        Read context from file into array of strings. Each array item contains one line from file.
        Write in to the file2.txt
        1) number of lines in file1.txt.
        2) the longest line in file1.txt.
        3) your name and birthday date.*/


public class Task4App {

    public static void main(String[] args) {

        ResumeFileConverter manager = new ResumeFileConverter();
        manager.setDataFile("resume.ser");
        manager.setOutputFile("file2.txt");
        Resume r = new Resume();
        r.setName("Igor Gavrilyuk");
        r.setDateOfBirth(Date.valueOf("2016-10-20"));
        r.setCareer("1998-2000 worked as a system administrator\n" +
                "2000-2008 worked as a system administrator\n" +
                "2006-2008 he worked in the bank\n" +
                "2008-20012 worked in a bank\n" +
                "20012-2016 is working");

        try {
            manager.writeDataToFile(r);

            Resume readResume = manager.readDataFromFile();
            System.out.println(readResume.toString());
            manager.writeDataToTxtFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
