package lesson2.person;

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

    public Person(int year, int month, int day, String name) {
        this.birthDay = new GregorianCalendar(year, (month-1), day);
        this.name = name;
    }

    public Date getBirthDay() {

        return birthDay.getTime();
    }

    public String getName() {
        return name;
    }

    public int age(){

        return (int)((new Date().getTime() - birthDay.getTimeInMillis())/31536000000L);
    }

    public void input (String aboutPerson){
        this.aboutPerson = aboutPerson;
    }

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
        return output();
    }
}
