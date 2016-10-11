package lesson3.country;

import java.util.ArrayList;

/**
 * Created by Admin on 10.10.16.
 */
public class Countries {

    private static ArrayList<Country> countries = new ArrayList<>();

    static
    {
        countries.add(new Country("the USA", Continent.NORTH_AMERICA));
        countries.add( new Country("German", Continent.EURASIA));
        countries.add(new Country("Ukraine", Continent.EURASIA));
        countries.add(new Country("Russia", Continent.EURASIA));

    }

    public static ArrayList<Country> getCountries() {
        return countries;
    }

    public static void add(Country country){
        countries.add(country);
    }
}
