package net.gavrilyuk.kennel;

import java.util.UUID;

/**
 * Dog Class
 * Created by Igor Gavryliuk on 07.10.2016.
 */

public class Dog {

    private UUID mId;
    private String mName;
    private Breed mBreed;
    private int mAge;

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
        mId = UUID.randomUUID();
        mName = name;
        mBreed = breed;
        mAge = age;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Breed getBreed() {
        return mBreed;
    }

    public void setBreed(Breed breed) {
        mBreed = breed;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
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
                "Id=" + mId.toString() +
                ", Name='" + mName + '\'' +
                ", Breed=" + mBreed +
                ", Age=" + ((mAge != -1)? mAge : "unknown") +
                '}';
    }
}
