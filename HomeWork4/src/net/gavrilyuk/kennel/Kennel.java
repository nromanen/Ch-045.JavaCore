package net.gavrilyuk.kennel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * Created by Igor Gavryliuk on 07.10.2016.
 */
public class Kennel {

    private ArrayList<Dog> mDogs;

    public Kennel() {
        mDogs = new ArrayList<>();
    }

    public void setDogs(ArrayList<Dog> dogs) {
        mDogs = dogs;
    }

    public void addDog(Dog dog) {
        mDogs.add(dog);
    }

    public ArrayList<Dog> getDogs() {
        return mDogs;
    }
    //check two dogs with the same name
    public boolean checkDogsSameName() {
        for (int i = 0; i < mDogs.size(); i++) {
            Dog checked = mDogs.get(i);
            for (int j = i + 1; j < mDogs.size(); j++) {
                if (mDogs.get(j).equals(checked)) {
                    return true;
                }
            }
        }
        return false;
    }

    //find oldest dog
    public Dog getOldestDog() {
        return Collections.max(mDogs, new Comparator<Dog>() {
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
