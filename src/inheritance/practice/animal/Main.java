package inheritance.practice.animal;

import java.util.ArrayList;
import java.util.List;

 /*
  * Create interface Animal with methods voice() and feed().
  * Create two classes Cat and Dog, which implement this interface.
  * Create array of Animal and add some Cats and Dogs to it.
  * Call voice() and feed() method for all of it
  */
public class Main {

    public static void main (String ... args){
        List<Animal> animals = new ArrayList<>();

        animals.add(new Dog("Jeck", 9));
        animals.add(new Cat("Murka", 2));

        for(Animal animal: animals){
            animal.feed();
            animal.voice();
        }


    }
}
