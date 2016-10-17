package AnimalTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evil on 17.10.16.
 */
public class AnimalList {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void showAnimal(){
        for (Animal animal: animals){
            System.out.print("Animal: ");
            animal.voice();
            animal.feed();
        }
    }
}
