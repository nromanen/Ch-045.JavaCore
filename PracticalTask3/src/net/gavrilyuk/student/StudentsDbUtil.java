package net.gavrilyuk.student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class to read and write information in the text file
 * Created by Igor Gavryliuk on 04.10.2016.
 */
public class StudentsDbUtil {

    public static final String DB_NAME = "students.db";
    public static final String DB_DELIMITER = ";";
    public static final int DB_TRANSACTION_OK = 1;
    public static final int DB_TRANSACTION_ERROR = 0;


    public static List<Student> readFromDb(String dbName) {
        List<Student> studentsList = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dbName) );
            studentsList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(DB_DELIMITER);
                Student student = new Student(record[0], Integer.parseInt(record[1]));
                studentsList.add(student);
            }
            reader.close();
        } catch (NumberFormatException eNum) {
            eNum.printStackTrace();
        } catch (FileNotFoundException eFnf) {
            //  ignore it
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException ioe) {
                //  ignore it
            }
        }
        return studentsList;
    }



    public static int addToDb(Student student) {
        int result;
        File dbFile = new File(DB_NAME);
        BufferedWriter bw = null;
        try {
            if (!dbFile.exists()) {
               boolean isNewDb = dbFile.createNewFile();
            }
            FileWriter fw = new FileWriter(dbFile.getAbsoluteFile(), true);//param true -  append records
            bw = new BufferedWriter(fw);
            if (student != null) {
                bw.write(student.getName() + DB_DELIMITER + student.getRating());
                bw.newLine();
                bw.flush();
            }
            result = DB_TRANSACTION_OK;
        } catch (IOException e) {
            result = DB_TRANSACTION_ERROR;
            e.printStackTrace();
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException ioe) {
                //  ignore it
            }
        }
        return result;
    }

    public static int removeOfDb(int index) {
        int result;
        try {
            File tmp = File.createTempFile("tmp", "");
            BufferedReader br = new BufferedReader(new FileReader(DB_NAME));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
            int recordNum = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (recordNum != index) {
                    bw.write(String.format("%s%n",line));
                }
                recordNum++;
            }
            br.close();
            bw.close();
            File oldFile = new File(DB_NAME);
            if (oldFile.delete()){
                if (tmp.renameTo(oldFile)){
                    result = DB_TRANSACTION_OK;
                } else {
                    System.out.println("unable rename file "+ oldFile);
                    result = DB_TRANSACTION_ERROR;
                }
            } else {
                System.out.println("unable delete file "+DB_NAME);
                result = DB_TRANSACTION_ERROR;
            }
        } catch (IOException e) {
            result = DB_TRANSACTION_ERROR;
            e.printStackTrace();
        }
        return result;
    }

}
