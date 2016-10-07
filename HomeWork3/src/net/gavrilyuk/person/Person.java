package net.gavrilyuk.person;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Person Class
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class Person {

    public static final String JSON_ID = "id";
    public static final String JSON_NAME = "Name";
    public static final String JSON_BIRTH_DAY = "BirthDay";

    private UUID mId;
    private String mName;
    private Date mBirthDay;

    public Person() {
        this.mId = UUID.randomUUID();
    }

    public Person(String name, Date mBirthDay ) {
        this.mId = UUID.randomUUID();
        this.mName = name;
        this.mBirthDay = mBirthDay;
    }

    public Person(JSONObject json) throws JSONException, ParseException {
        mId = UUID.fromString(json.getString(JSON_ID));
        mName = json.getString(JSON_NAME);
        mBirthDay = new SimpleDateFormat("dd.MM.yyyy").parse(json.getString(JSON_BIRTH_DAY));
        //mBirthDay =    json.get(JSON_BIRTH_DAY);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_NAME, mName);
        json.put(JSON_BIRTH_DAY, new SimpleDateFormat("dd.MM.yyyy ").format(mBirthDay));
        return json;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Date getBirthDay() {
        return mBirthDay;
    }

    public void setBirthDay(Date mBirthDay) {
        this.mBirthDay = mBirthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + mName + '\'' +
                ", BirthDay=" + new SimpleDateFormat("dd.MM.yyyy ").format(mBirthDay)+
                ", Age="+age()+
                '}';
    }

    public int age() {
        return PersonUtil.calculateAge(mBirthDay);
    }

    public void input(String name, Date date) {
        this.mName = name;
        this.mBirthDay = date;
    }

    public String output() {
            return this.toString();
    }

    public void changeName(String newName) {
        this.mName = newName;
    }
}
