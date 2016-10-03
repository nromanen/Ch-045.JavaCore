package net.gavrilyuk.person;

/**
 *  Person class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Person {

    private String mName;
    private int mAge;
    private String mAddress;

    public Person() {
    }

    public Person(String name, int age, String address) {
        mName = name;
        mAge = age;
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPersonData() {
        return "You Name="+mName+"  You age="+mAge+"  You Address="+mAddress;
    }

}
