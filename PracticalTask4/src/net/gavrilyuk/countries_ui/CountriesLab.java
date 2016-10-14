package net.gavrilyuk.countries_ui;

import java.util.ArrayList;

/**
 * Employee Lab Class
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class CountriesLab {

    private static final String DB_FILENAME = "countryinfo.json";
    private static CountriesLab sEmployeeLab;

    private ArrayList<CountryInfo> mCountries;
    private CountriesJSONSerializer mSerializer;


    private CountriesLab() {
        mSerializer = new CountriesJSONSerializer(DB_FILENAME);
        try {
            mCountries = mSerializer.loadCountries();
        } catch (Exception e) {
            mCountries = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public static CountriesLab get() {
        if (sEmployeeLab == null) {
            sEmployeeLab = new CountriesLab();
        }
        return sEmployeeLab;
    }

    public CountryInfo getCountry(int id) {
        for (CountryInfo e : mCountries) {
            if (e.getId()==(id))
                return e;
        }
        return null;
    }

    public void addCountry(CountryInfo e) {
        mCountries.add(e);
        saveEmployees();
    }

    public void removeEmployee(int index) {
        mCountries.remove(index);
        saveEmployees();
    }

    public ArrayList<CountryInfo> getCountries() {
        return mCountries;
    }

    public boolean saveEmployees() {
        try {
            mSerializer.saveCountries(mCountries);
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }
}
