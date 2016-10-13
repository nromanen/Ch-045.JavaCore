package net.gavrilyuk.countries;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class Country {

    private String name;
    private String iso;
    private Continents continent;

    public Country(String name, Continents continent) {
        this.name = name;
        this.continent = continent;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Continents getContinent() {
        return continent;
    }

    public void setContinent(Continents continent) {
        this.continent = continent;
    }
}
