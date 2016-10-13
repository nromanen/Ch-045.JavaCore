package net.gavrilyuk.flowerbeds;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple class for writing data to a text file
 * Created by Igor Gavryliuk on 29.09.2016.
 */
public class DbUtil {

    public static final String DB_NAME = "flower_db.txt";
    public static final String DB_DELIMITER = ";";
    public static final int WRITE_STATUS_OK = 1;
    public static final int WRITE_STATUS_ERROR = 0;


    public static List<FlowerBed> readDb(String dbName) {
        List<FlowerBed> flowerBedsList = null;
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader(dbName) );
            flowerBedsList = new ArrayList<>();
            String line;
            while ((line = input.readLine()) != null) {
                String[] record = line.split(DB_DELIMITER);
                FlowerBed flowerBed = new FlowerBed(Float.parseFloat(record[0]));
                flowerBedsList.add(flowerBed);
            }
        } catch (NumberFormatException eNum) {
            System.out.println("Ops "+eNum.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return flowerBedsList;
    }

    public static int saveToDb(FlowerBed flowerBed) {
        int result;
        File dbFile = new File(DB_NAME);
        BufferedWriter bw = null;
        try {
            if (!dbFile.exists()) {
                dbFile.createNewFile();
            }
            FileWriter fw = new FileWriter(dbFile.getAbsoluteFile(), true);//param true -  append records
            bw = new BufferedWriter(fw);
            if (flowerBed != null) {
                bw.write(flowerBed.getRadius() + DB_DELIMITER + flowerBed.getArea() + DB_DELIMITER + flowerBed.getPerimeter());
                bw.newLine();
                bw.flush();
            }
            result = WRITE_STATUS_OK;
        } catch (IOException e) {
            result = WRITE_STATUS_ERROR;
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

    public static String printDbData() {
        List<FlowerBed> flowerBeds = readDb(DB_NAME);
        StringBuilder builder = new StringBuilder();
        if (flowerBeds != null ) {
            if (flowerBeds.size() > 0) {
                builder.append("-------------- Flower Beds list ------------").append("\n");
                for (FlowerBed flowerBed : flowerBeds) {
                    builder.append(flowerBed.getData()).append("\n");
                }
                builder.append("------------------------------------------------").append("\n");
            } else builder.append("flowerDb is empty!");

        }
        return builder.toString();
    }

}
