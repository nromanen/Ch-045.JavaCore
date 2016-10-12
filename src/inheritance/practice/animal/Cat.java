package inheritance.practice.animal;

import static util.Print.println;


public class Cat implements Animal {

    private String name;
    private int age;

    public Cat(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void voice() {
        println("Myau-myau");
    }

    @Override
    public void feed() {
        println("I'm a cat. I like mouses");
    }
}
