package startinterface;

import java.util.ArrayList;



public class Main {
	public static void main(String[] args) {
		ArrayList<String> animalsNameList = new ArrayList<String>();
		Cat cat1 = new Cat("Barsik");
		animalsNameList.add(cat1.name);
		Cat cat2 = new Cat("Pushok");
		animalsNameList.add(cat2.name);
		Cat cat3 = new Cat("Kuzia");
		animalsNameList.add(cat3.name);
		Dog dog1 = new Dog("Bobik");
		animalsNameList.add(dog1.name);
		Dog dog2 = new Dog("Sharik");
		animalsNameList.add(dog2.name);
		Dog dog3 = new Dog("Shrek");
		animalsNameList.add(dog3.name);

		/*for (int i = 0; i < animalsNameList.size(); i++) {
			System.out.println(animalsNameList.get(i));
		}*/
		cat1.voice();
		dog1.feed();

	}
}
