package conditional.homework.dog;

import java.util.ArrayList;
import java.util.Collections;

import static conditional.homework.dog.DogService.*;
import static util.Print.println;

 /*
  * Ñreate class Dog with fields name, breed, age.
  * Declare enum for field breed.
  * Create 3 instances of type Dog.
  * Check if there is no two dogs with the same name.
  * Display the name and the kind of the oldest dog.
  */

public class Main {

    public static void main(String[] args){

        ArrayList<Dog> myDogs = new ArrayList<>();

        myDogs.add(new Dog("Chapa", 7, Breed.CHIHUAHUA));
        myDogs.add(new Dog("Arven", 2, Breed.BORDER_COLLIE));
        myDogs.add(new Dog("Barsik", 4, Breed.UNKNOWN));

        println("You " +  (hasSameName(myDogs)? "have" : "have not") + " dogs with the same names!");
        Collections.sort(myDogs, DogService.compareByAge);

        println("The oldest dog is " + myDogs.get(0).getName() + ". His breed is " + myDogs.get(0).getBreed());

    }
}
