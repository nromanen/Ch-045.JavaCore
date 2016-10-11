package homework3.homework.dog;

import java.util.ArrayList;
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
public class MainDog {
    public static void main(String[] args){

        Dog dog1,dog2,dog3;

        dog1 = new Dog("duncan", Breed.PINCHER, 7);
        dog2 = new Dog("staff", Breed.MASTIFF, 5);
        dog3 = new Dog("staff", Breed.ROTTWEILER, 6);

        List<Dog> dogs = new ArrayList<Dog>();

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        //Check if there is no two dogs with the same name.
        if(dog1.equals(dog2) || dog1.equals(dog3) || dog2.equals(dog3)){
            System.out.println("two dogs with the same name: true");
        } else {
            System.out.println("two dogs with the same name: false");
        }

        //Find oldest dog
        int oldestDog = 0;
        Dog result = null;

        System.out.println("Oldest dog:");
        for(Dog dog: dogs){
            if(dog.getAge() > oldestDog){
                oldestDog = dog.getAge();
                result = dog;
            }
        }
        System.out.print(result);
    }
}
