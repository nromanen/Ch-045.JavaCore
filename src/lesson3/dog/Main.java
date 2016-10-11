package lesson3.dog;

import java.util.ArrayList;
import java.util.Collections;

import static lesson3.dog.DogService.*;
import static util.Print.println;

/**
 * Created by Admin on 11.10.16.
 */
public class Main {

    public static void main(String[] args){

        ArrayList<Dog> myDogs = new ArrayList<>();

        myDogs.add(new Dog("Chapa", 7, Breed.CHIHUAHUA));
        myDogs.add(new Dog("Arven", 2, Breed.BORDER_COLLIE));
        myDogs.add(new Dog("Barsik", 4, Breed.UNKNOWN));

        println("You " +  (hasSameName(myDogs)? "have" : "have not") + " have dogs with the same names!");
        Collections.sort(myDogs, DogService.compareByAge);

        println("The oldest dog is " + myDogs.get(0).getName() + ". His breed is " + myDogs.get(0).getBreed());


    }
}
