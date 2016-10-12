package conditional.homework.dog;

import java.util.ArrayList;
import java.util.Comparator;


public class DogService {

    // Check age is correct
    public static boolean correctAge(int age){
        if (age >= 0 && age <= 25) {
            return true;
        } else {
            return false;
        }
    }

    // compare two dogs by name
    public static Comparator<Dog> compareByName = new Comparator<Dog>() {
        public int compare(Dog dog1, Dog dog2) {
            return dog1.getName().compareTo(dog2.getName());
        }
    };

    // compare two dogs by age
    public static Comparator<Dog> compareByAge = new Comparator<Dog>() {
        public int compare(Dog dog1, Dog dog2) {
            return dog1.getAge() - dog2.getAge();
        }
    };

    // Method check are two dogs with the same name
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
