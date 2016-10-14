package net.gavrilyuk.countries_ui;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class CountryInfo {

    private  String mCountryCode;
    private  String mContinent;
    private  long mPopulation;
    private  double mArea;
    private  String mCapital;
    private  int mId;
    private String mCountryName;
   // private AllContinents mContinent;



    public String getCountryName() {
        return mCountryName;
    }

    public CountryInfo(JSONObject json) throws JSONException {
        mId = json.getInt("_id");
        mContinent = json.getString("continent");
        mCountryName = json.getString("countryName");
        mCountryCode = json.getString("countryCode");
        mCapital = json.getString("capital");
        mArea = json.getDouble("areaInSqKm");
        mPopulation = json.getLong("population");
    }


    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
    }

    public String getContinent() {
        return  mContinent;
    }

    public void setContinent(String continent) {
        mContinent = continent;
    }

    public long getPopulation() {
        return mPopulation;
    }

    public void setPopulation(long population) {
        mPopulation = population;
    }

    public double getArea() {
        return mArea;
    }

    public void setArea(double area) {
        mArea = area;
    }

    public String getCapital() {
        return mCapital;
    }

    public void setCapital(String capital) {
        mCapital = capital;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setCountryName(String countryName) {
        mCountryName = countryName;
    }
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public String toString() {
        return "Country{" +
                "mCountryCode='" + mCountryCode + '\'' +
                ", mContinent='" + mContinent + '\'' +
                ", mPopulation=" + mPopulation +
                ", mArea=" + mArea +
                ", mCapital='" + mCapital + '\'' +
                ", mId=" + mId +
                ", mCountryName='" + mCountryName + '\'' +
                '}';
    }
}
