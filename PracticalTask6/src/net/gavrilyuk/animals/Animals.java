package net.gavrilyuk.animals;

/**
 *
 * Created by Igor Gavrilyuk on 09.10.2016.
 */

public class Animals {

    private Object[] mAnimals;

    public Animals(int count) {
        mAnimals = new Object[count];
        for (Object animal : mAnimals) {
            animal = new Object();
        }
    }

    public Animals(Object[] animals) {
        mAnimals = animals;
    }

    public Object[] getAnimals() {
        return mAnimals;
    }

    public void setAnimals(Object[] animals) {
        mAnimals = animals;
    }

    public void addAnimal(int pos,Object animal) {
        mAnimals[pos] = animal;
    }

    public void voiceAll() {
        for (Object animal : mAnimals) {
            if (animal instanceof Dog)((Dog)animal).voice();
            if (animal instanceof Cat){
                ((Cat) animal).voice();
            }
        }
    }

    public void feedAll() {
        for (Object animal : mAnimals) {
            if (animal instanceof Dog) ((Dog)animal).feed();
            if (animal instanceof Cat) ((Cat) animal).feed();

        }
    }
}
