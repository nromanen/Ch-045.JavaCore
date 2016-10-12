package inheritance.practice.animal;

import static util.Print.println;


public class Dog implements Animal {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.age = age;
        this.name = name;
    }


    @Override
    public void feed() {
        println("I'm dog. i like bones");
    }

    @Override
    public void voice() {
        println("Gav-gav");
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
