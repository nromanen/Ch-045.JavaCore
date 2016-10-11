package lesson3.dog;

import static lesson3.dog.DogService.*;

/**
 * Created by Admin on 11.10.16.
 */
public class Dog {
    private String name = "Unknown dog";
    private int age = 0;
    private Breed breed = Breed.UNKNOWN;

    public Dog(){
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, Breed breed) {
        this(name);
        this.breed = breed;
    }

    public Dog(String name, int age, Breed breed) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (correctAge(age)) {
            this.age = age;
        }
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog dog = (Dog) o;

        if (getAge() != dog.getAge()) return false;
        if (getName() != null ? !getName().equals(dog.getName()) : dog.getName() != null) return false;
        return getBreed() == dog.getBreed();

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (getBreed() != null ? getBreed().hashCode() : 0);
        return result;
    }
}
