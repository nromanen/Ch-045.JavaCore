package net.gavrilyuk.countries;

/**
 * Countries Info Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class CountriesInfo {

    public static void main(String[] args) {
        Country country = new Country("Ukraine", Continents.EUROPE);
        System.out.println("Country info:name=" + country.getName() + " continent=" + country.getContinent().getName());
        Country country1 = new Country("USA", Continents.NORTH_AMERICA);
        System.out.println("Country info:name=" + country1.getName() + " continent=" + country1.getContinent().getName());
    }
}
