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
 * Created by Igor Gavrilyuk on 05.10.2016.
 */

public class Employee {

    public static final String JSON_ID = "id";
    public static final String JSON_NAME = "Name";
    public static final String JSON_HOURS = "Hours";
    public static final String JSON_RATE = "Rate";

    private UUID id;
    private String name;
    private long hours;
    private double rate;

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
        this.id = UUID.randomUUID();
        this.name = name;
        this.hours = hours;
        this.rate = rate;
    }

    public Employee(JSONObject json) throws JSONException {
        id = UUID.fromString(json.getString(JSON_ID));
        name = json.getString(JSON_NAME);
        rate = json.getDouble(JSON_RATE);
        hours = json.getLong(JSON_HOURS);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_ID, id.toString());
        json.put(JSON_NAME, name);
        json.put(JSON_RATE, rate);
        json.put(JSON_HOURS, hours);
        return json;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void changeRate(int rate) {
        setRate(rate);
    }

    @Override
    public String toString() {
        return "Employee [Name=" + name +  ", Hours=" + hours +", Rating=" + rate + "]";
    }

    public double salary() {
        return rate * hours;
    }

    public double bonuses() {
        return salary() * 0.1;
    }
}
