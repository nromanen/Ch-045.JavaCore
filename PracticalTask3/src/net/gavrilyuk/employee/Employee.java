package net.gavrilyuk.employee;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Employee Class
 *
 *
 * todo Practical work additional tasks
 * todo поля для вводу годин та ставки мають бути тільки числа і не бути пустими!
 * todo Прізвище та імя мають починатися з великої букви та не містити цифр і т.д. і не бути пустим!
 * todo нарахувати бонус тільки 5 пасажирам які мають найбільшу кількість годин
 * Created by igor on 05.10.2016.
 */

public class Employee {

    public static final String JSON_ID = "id";
    public static final String JSON_NAME = "Name";
    public static final String JSON_HOURS = "Hours";
    public static final String JSON_RATE = "Rate";

    private UUID mId;
    private String mName;
    private long mHours;
    private double mRate;

    public Employee() {
        this("", 0, 0);
    }

    public Employee(String name) {
        this(name, 0, 0);
    }

    public Employee(String name, int rate) {
        this(name, rate, 0);
    }

    public Employee(String name, int rate, int hours ) {
        this.mId = UUID.randomUUID();
        this.mName = name;
        this.mHours = hours;
        this.mRate = rate;
    }

    public Employee(JSONObject json) throws JSONException {
        mId = UUID.fromString(json.getString(JSON_ID));
        mName = json.getString(JSON_NAME);
        mRate = json.getDouble(JSON_RATE);
        mHours = json.getLong(JSON_HOURS);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_NAME, mName);
        json.put(JSON_RATE, mRate);
        json.put(JSON_HOURS, mHours);
        return json;
    }

    public String getName() {
        return mName;
    }

    public UUID getId() {
        return mId;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public long getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        this.mHours = hours;
    }

    public double getRate() {
        return mRate;
    }

    public void setRate(double rate) {
        this.mRate = rate;
    }

    public void changeRate(int rate) {
        setRate(rate);
    }

    @Override
    public String toString() {
        return "Employee [Name=" + mName +  ", Hours=" + mHours +", Rating=" + mRate + "]";
    }

    public double salary() {
        return mRate * mHours;
    }

    public double bonuses() {
        return salary() * 0.1;
    }
}
