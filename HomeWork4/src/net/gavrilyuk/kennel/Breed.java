package net.gavrilyuk.kennel;

/**
 *  Breed Enum
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public enum Breed {

    WITH_OUT_BREED("With out breed"),
    ENGLISH_MASTIFF("English mastiff"),
    NEWFOUNDLAND("Newfoundland"),
    KOMONDOR("Komondor"),
    ST_BERNAR("St. Bernard"),;


    private String mKind;

    Breed(String kind) {
        mKind = kind;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }
}
