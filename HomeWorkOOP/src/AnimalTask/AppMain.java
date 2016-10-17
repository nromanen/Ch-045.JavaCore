package AnimalTask;

/**
 * Created by evil on 17.10.16.
 */

/*
    Create interface Animal with methods voice() and feed().
    Create two classes Cat and Dog, which implement this interface.
    Create array of Animal and add some Cats and Dogs to it.
    Call voice() and feed() method for all of it
 */
public class AppMain {
    public static void main(String[] args) {
        AnimalList animalList = new AnimalList();
        animalList.addAnimal(new Cat());
        animalList.addAnimal(new Dog());
        animalList.showAnimal();
    }
}
