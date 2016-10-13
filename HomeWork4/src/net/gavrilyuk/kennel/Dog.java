package net.gavrilyuk.kennel;

import java.util.UUID;

/**
 * Dog Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */

public class Dog {

    private UUID id;
    private String name;
    private Breed breed;
    private int age;

    public Dog() {
        this("unknown",  Breed.WITH_OUT_BREED, -1);
    }

    public Dog(Breed breed) {
        this("unknown", breed, -1);//-1 - unknown age
    }

    public Dog(String name, Breed breed) {
        this(name, breed, -1);
    }

    public Dog(String name) {
        this(name, Breed.WITH_OUT_BREED, -1);
    }

    public Dog(String name, Breed breed, int age) {
        id = UUID.randomUUID();
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
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
        return getName().equals(dog.getName());

    }


    @Override
    public String toString() {
        return "Dog{" +
                "Id=" + id.toString() +
                ", Name='" + name + '\'' +
                ", Breed=" + breed +
                ", Age=" + ((age != -1)? age : "unknown") +
                '}';
    }
}
