package lesson3.dog;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Admin on 11.10.16.
 */
public class DogService {

    public static boolean correctAge(int age){
        if (age >= 0 && age <= 25) {
            return true;
        } else {
            return false;
        }
    }

    public static Comparator<Dog> compareByName = new Comparator<Dog>() {
        public int compare(Dog dog1, Dog dog2) {
            return dog1.getName().compareTo(dog2.getName());
        }
    };

    public static Comparator<Dog> compareByAge = new Comparator<Dog>() {
        public int compare(Dog dog1, Dog dog2) {
            return dog1.getAge() - dog2.getAge();
        }
    };

    public static boolean hasSameName(ArrayList<Dog> dogs, String... name){
        if (name.length == 0) {
            for (int i = 0; i < dogs.size() - 1; i++){
                for (int j = i + 1; j < dogs.size(); j++){
                    if (dogs.get(i).getName().equals(dogs.get(j).getName())){
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < name.length; i++){
                for (int j = 0; j < dogs.size(); j++){
                    if(name[i].equals(dogs.get(j).getName())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
