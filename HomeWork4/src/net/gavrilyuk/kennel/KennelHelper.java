package net.gavrilyuk.kennel;

/**
 * Create class Dog with fields name, breed, age.
 * Declare enum for field breed.
 * Create 3 instances of type Dog.
 * Check if there is no two dogs with the same name.
 * Display the name and the kind of the oldest dog.
 * Add Unit Tests to each task, publish code on GitHub
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class KennelHelper {

    public static void main(String[] args) {
        Kennel kennel = new Kennel();
        Dog dog = new Dog("Tusik",Breed.WITH_OUT_BREED,1);
        kennel.addDog(dog);
        Dog dog1 = new Dog("Belka",Breed.ENGLISH_MASTIFF,5);
        kennel.addDog(dog1);
        Dog dog2 = new Dog("Strelka",Breed.KOMONDOR,10);
        kennel.addDog(dog2);
        Dog dog3 = new Dog("Strelka",Breed.ST_BERNAR,2);
        kennel.addDog(dog3);
        System.out.println(dog.toString());
        System.out.println("The oldest dog: Name="+kennel.getOldestDog().getName()+" kind="+kennel.getOldestDog().getBreed().name());
        System.out.println("Is two dogs with the same name:" +kennel.checkDogsSameName());
    }
}
