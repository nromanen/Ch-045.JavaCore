package net.gavrilyuk.countries;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class Country {

    private String mName;
    private String mISO;
    private Continents mContinent;

    public Country(String name, Continents continent) {
        mName = name;
        mContinent = continent;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getISO() {
        return mISO;
    }

    public void setISO(String ISO) {
        mISO = ISO;
    }

    public Continents getContinent() {
        return mContinent;
    }

    public void setContinent(Continents continent) {
        mContinent = continent;
    }
}
