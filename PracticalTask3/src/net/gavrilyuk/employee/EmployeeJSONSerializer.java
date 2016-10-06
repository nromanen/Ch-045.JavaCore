package net.gavrilyuk.employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

/**
 * Responsibility for recording existing list ArrayList of objects in the Employee format
 * JSON delegated class EmployeeJSONSerializer
 *
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeJSONSerializer {

    private String mFilename;

    public EmployeeJSONSerializer(String f) {
        mFilename = f;
    }

    public ArrayList<Employee> loadEmployee() throws IOException, JSONException {
        ArrayList<Employee> crimes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            reader = new BufferedReader(new FileReader(mFilename));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            // parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // build the array of crimes from JSONObjects
            for (int i = 0; i < array.length(); i++) {
                crimes.add(new Employee(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens when we start fresh
        } finally {
            if (reader != null)
                reader.close();
        }
        return crimes;
    }

    public void saveEmployee(ArrayList<Employee> employees) throws JSONException, IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (Employee c : employees)
            array.put(c.toJSON());
        // write the file to disk
        Writer writer = null;
        try {
            OutputStream out = new FileOutputStream(mFilename);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}

