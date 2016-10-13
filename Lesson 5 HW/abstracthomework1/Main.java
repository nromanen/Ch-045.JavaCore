package abstracthomework1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Bird> birds = new ArrayList<>();
		birds.add(new Chicken());
		birds.add(new Penguin());
		birds.add(new Sparrow());
		birds.add(new Eagle());

		for (Bird bird : birds) {
			bird.fly();
			bird.info();
		}
		
	}

}
