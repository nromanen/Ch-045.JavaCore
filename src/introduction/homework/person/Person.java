package introduction.homework.person;


public class Person {

    private String name;
    private int age;
    private String address;

    public Person(String name) {
        this.name = name;
    }

    public Person(String address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    // seters and geters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
