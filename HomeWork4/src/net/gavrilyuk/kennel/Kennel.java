package net.gavrilyuk.kennel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class Kennel {

    private List<Dog> dogs;

    public Kennel() {
        dogs = new ArrayList<>();
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return dogs;
    }
    //check two dogs with the same name
    public boolean checkDogsSameName() {
        if (dogs != null) {
            for (int i = 0; i < dogs.size(); i++) {
                Dog checked = dogs.get(i);
                for (int j = i + 1; j < dogs.size(); j++) {
                    if (dogs.get(j).equals(checked)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //find oldest dog
    public Dog getOldestDog() {
        return Collections.max(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                if (d1.getAge() < d2.getAge())
                    return -1;
                if (d1.getAge() == d2.getAge())
                    return 0;
                return 1;

            }
        });
    }

}
