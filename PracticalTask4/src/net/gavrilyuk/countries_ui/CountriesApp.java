package net.gavrilyuk.countries_ui;

import javax.swing.*;

/**
 * Countries Info Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class CountriesApp {

    public static void main(String[] args) {
       /* CountryInfo country = new CountryInfo("Ukraine", AllContinents.EUROPE);
        System.out.println("CountryInfo info:name=" + country.getCountryName() + " continent=" + country.getContinent().getCountryName());
        CountryInfo country1 = new CountryInfo("USA", AllContinents.NORTH_AMERICA);
        System.out.println("CountryInfo info:name=" + country1.getCountryName() + " continent=" + country1.getContinent().getCountryName());*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CountriesWindow("Countries Info").setVisible(true);
            }
        });
    }
}
