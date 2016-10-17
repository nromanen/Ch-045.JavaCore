package AnimalTask;

/**
 * Created by evil on 17.10.16.
 */
public class AppMain {
    public static void main(String[] args) {
        AnimalList animalList = new AnimalList();
        animalList.addAnimal(new Cat());
        animalList.addAnimal(new Dog());
        animalList.showAnimal();
    }
}
