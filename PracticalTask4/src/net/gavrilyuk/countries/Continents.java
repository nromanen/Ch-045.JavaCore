package net.gavrilyuk.countries;

/**
 * Continents Enum
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public enum Continents {

    AFRICA("AF","Africa"), ASIA("AS","Asia"),
    ANTARCTICA("AN","Antarctica"), EUROPE("EU","Europe"),
    NORTH_AMERICA("NA","North America"), OCEANIA("OC","Oceania"),
    SOUTH_AMERICA("SA","South America");

    private String mCode;
    private String mName;


    Continents(String code, String name) {
        mCode = code;
        mName = name;
    }

    public String getCode() {
        return mCode;
    }

    public String getName() {
        return mName;
    }
}
