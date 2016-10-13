package net.gavrilyuk.employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsibility for recording existing list ArrayList of objects in the Employee format
 * JSON delegated class EmployeeJSONSerializer
 *
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class EmployeeJSONSerializer {

    private String filename;

    public EmployeeJSONSerializer(String f) {
        filename = f;
    }

    public List<Employee> loadEmployee() throws IOException, JSONException {
        List<Employee> employees = new ArrayList<>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            reader = new BufferedReader(new FileReader(filename));
            StringBuilder jsonString = new StringBuilder();
            String line ;
            while ((line = reader.readLine()) != null) {
                // line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            // parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // build the array of crimes from JSONObjects
            for (int i = 0; i < array.length(); i++) {
                employees.add(new Employee(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens when we start fresh
        } finally {
            if (reader != null)
                reader.close();
        }
        return employees;
    }

    public void saveEmployee(List<Employee> employees) throws JSONException, IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (Employee c : employees)
            array.put(c.toJSON());
        // write the file to disk
        Writer writer = null;
        try {
            OutputStream out = new FileOutputStream(filename);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}

