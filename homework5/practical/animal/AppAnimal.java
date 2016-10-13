package hohework5.practical.animal;

/**
 * Created by roma on 13.10.2016.
 */
public class AppAnimal {
    public static void main(String[] args){

        Animal[] animals = new Animal[4];
        animals[0] = new Cat("green");
        animals[1] = new Cat("kiti");
        animals[2] = new Dog("wolf");
        animals[3] = new Dog("hot-dog");

        for(Animal animal: animals){
            System.out.println(animal);
        }
    }
}
