package net.gavrilyuk.countries_ui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 05.10.2016.
 */
public class CountriesModel extends AbstractTableModel {

    private final static int COLUMN_COUNT = 8;


    private ArrayList<CountryInfo> mCountries;

    public CountriesModel() {
        mCountries = new ArrayList<>();//create empty
    }

    public ArrayList<CountryInfo> getData() {
        return mCountries;
    }

    public void sortData() {
        Collections.sort(mCountries, new Comparator<CountryInfo>() {
            @Override
            public int compare(CountryInfo c1, CountryInfo c2) {
                if (c1.getPopulation() > c2.getPopulation()) //sort by population
                    return -1; // highest value first
                if (c1.getPopulation() == c2.getPopulation())
                    return 0;
                return 1;
                /*String[] strings1 = c1.getCountryName().split("\\s"); //sort by name
                String[] strings2 = c2.getCountryName().split("\\s");
                return strings1[strings1.length - 1]
                        .compareTo(strings2[strings2.length - 1]);*/
            }
        });
        fireTableDataChanged();
    }

    public void setData(ArrayList<CountryInfo> countries) {
        if (countries != null) {
            mCountries = countries;
            fireTableDataChanged();
        }

    }

    public void addCountry(CountryInfo country) {
        if (country != null) {
                CountriesLab.get().addCountry(country);
              //  sortData();
            fireTableDataChanged();
        }
    }

    public void removeCountry(int index) {
          CountriesLab.get().removeEmployee(index);
        //  sortData();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return mCountries != null ? mCountries.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int r, int c) {

        switch (c) {
            case 0:
                return mCountries.indexOf(mCountries.get(r))+1;
            case 1:
                return mCountries.get(r).getCountryCode();
            case 2:
                return mCountries.get(r).getCountryName();
            case 3:
                return mCountries.get(r).getCountryCode();
            case 4:
                return mCountries.get(r).getCapital();
            case 5:
                return String.format("%,d", mCountries.get(r).getPopulation());
            case 6:
                return getContinentName(mCountries.get(r).getContinent()) ;
            case 7:
                return String.format("%,.2f", mCountries.get(r).getArea());


            default:
                return "";
        }

    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Num";
            case 1:
                return "Country Flag";
            case 2:
                return "Country name";
            case 3:
                return "ISO Code";
            case 4:
                return "Capital";
            case 5:
                return "Population";
            case 6:
                return "Continent";
            case 7:
                return "Area km2";

            default:
                return "Invalid Column";
        }
    }

    private String getContinentName(String code) {
        for (AllContinents continent : AllContinents.values()) {
            if (continent.getCode().equalsIgnoreCase(code)) {
                return continent.getName();
            }
        }
        return "";
    }


}
