package startinterface;

import java.util.List;
import java.util.ArrayList;
/*Create interface Animal with methods voice() and feed(). 
 * Create two classes Cat and Dog, which implement this interface.
 *  Create array of Animal and add some Cats and Dogs to it. 
 * Call voice() and feed() method for all of it
 */

public class Main {
	public static void main(String[] args) {

		ArrayList<Animal> animalsNameList = new ArrayList<>();
		Cat cat1 = new Cat("Barsik");
		animalsNameList.add(cat1);
		Cat cat2 = new Cat("Pushok");
		animalsNameList.add(cat2);
		Cat cat3 = new Cat("Kuzia");
		animalsNameList.add(cat3);
		Dog dog1 = new Dog("Bobik");
		animalsNameList.add(dog1);
		Dog dog2 = new Dog("Sharik");
		animalsNameList.add(dog2);
		Dog dog3 = new Dog("Shrek");
		animalsNameList.add(dog3);

		for (Animal animal : animalsNameList) {
			animal.feed();
			animal.voice();
		}
	}
}

