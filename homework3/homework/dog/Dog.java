package homework3.homework.dog;

import java.util.List;

/**
 * Created by roma on 10.10.2016.
 *
 * Сreate class Dog with fields name, breed, age.
 * Declare enum for field breed.
        * Create 3 instances of type Dog.
        * Check if there is no two dogs with the same name.
        * Display the name and the kind of the oldest dog.
 */

public class Dog {

    private List<Dog> dogs;
    private String name;
    private Enum<Breed> breed;
    private int age;

    public Dog(){}

    public Dog (String name, Enum<Breed> breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBreed(Enum<Breed> breed) {
        this.breed = breed;
    }

    public Enum<Breed> getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;
        if (!name.equals(dog.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString(){
        return String.format("name: %-10s breed: %-10s",name,breed);
    }
}
