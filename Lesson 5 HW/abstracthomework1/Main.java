package abstracthomework1;
/*Develop abstract class Bird with attributes feathers and layEggs and an abstarct method fly(). 
 *  Develop classes FlyingBird and NonFlyingBird. Create class Eagle, Swallow, Penguin and Chicken. 
Create array Bird and add different birds to it. 
Call fly() method for all of it. Output the information about each type of created bird.  */

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
			//bird.info();
		}

	}

}
