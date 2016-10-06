package Person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by evil on 06.10.16.
 */
class Person {
    private String name;
    private String  birthYear;
    public Person(){}
    public Person(String name, String birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public int age(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate today = LocalDate.now();
        today.format(formatter);
        LocalDate date = LocalDate.parse(birthYear, formatter);
        Period age = Period.between(date, today);
        return age.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", age='" + age() + " years" + '\'' +
                '}';
    }
}
