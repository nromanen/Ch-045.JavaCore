package classandobject.homework.person;

import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

    private String name;
    private GregorianCalendar birthDay;
    private String aboutPerson = "";

    public Person() {
        this.name = "Unknown person";
        this.birthDay = new GregorianCalendar();
    }

    public Person(String name, int year, int month, int day) {
        this.birthDay = new GregorianCalendar(year, (month-1), day);
        this.name = name;
    }

    // geters
    public Date getBirthDay() {

        return birthDay.getTime();
    }

    public String getName() {
        return name;
    }

    // Method return age of the perdon
    public int age(){

        return (int)((new Date().getTime() - birthDay.getTimeInMillis())/31536000000L);
    }

    // Method add information about person
    public void input (String aboutPerson){
        this.aboutPerson = aboutPerson;
    }

    // Method return all information about person
    public String output(){
        String result = "My name is " + this.name + ". I am " + age() + " years old. \n" +
                "Information about me: \n";
        if (this.aboutPerson == ""){
            result += "No information!";
        } else {
            result += this.aboutPerson;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name: " + this.name +
                ", age: " + this.age() +'}';
    }
}
