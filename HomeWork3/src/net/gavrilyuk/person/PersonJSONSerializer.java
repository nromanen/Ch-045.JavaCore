package net.gavrilyuk.person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * Created by GipSoft on 05.10.2016.
 */
public class PersonJSONSerializer {

    private String mFilename;

    public PersonJSONSerializer(String f) {
        mFilename = f;
    }

    public ArrayList<Person> loadPerson() throws IOException, JSONException, ParseException {
        ArrayList<Person> crimes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(mFilename));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();

            for (int i = 0; i < array.length(); i++) {
                crimes.add(new Person(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // ignore it
        } finally {
            if (reader != null)
                reader.close();
        }
        return crimes;
    }

    public void savePerson(ArrayList<Person> persons) throws JSONException, IOException {
        JSONArray array = new JSONArray();
        for (Person c : persons)
            array.put(c.toJSON());
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
