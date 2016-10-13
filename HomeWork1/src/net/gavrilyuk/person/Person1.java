package net.gavrilyuk.person;

/**
 *  Person class
 * Created by Igor Gavryliuk on 28.09.2016.
 */
public class Person1 {

    private String name;
    private int age;
    private String address;

    public Person1() {
    }

    public Person1(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonData() {
        return "You Name="+ name +"  You age="+ age +"  You Address="+ address;
    }

}
