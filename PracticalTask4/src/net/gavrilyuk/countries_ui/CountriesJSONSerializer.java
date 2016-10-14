package net.gavrilyuk.countries_ui;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

/**
 * Responsibility for recording existing list ArrayList of objects in the Employee format
 * JSON delegated class CountriesJSONSerializer
 *
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class CountriesJSONSerializer {

    private String mFilename;

    public CountriesJSONSerializer(String f) {
        mFilename = f;
    }

    public ArrayList<CountryInfo> loadCountries() throws IOException, JSONException {
        ArrayList<CountryInfo> countries = new ArrayList<>();
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
            // build the array of countries_ui from JSONObjects
            for (int i = 0; i < array.length(); i++) {
                countries.add(new CountryInfo(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens when we start fresh
        } finally {
            if (reader != null)
                reader.close();
        }
        return countries;
    }

    public void saveCountries(ArrayList<CountryInfo> countries) throws JSONException, IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (CountryInfo c : countries)
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

