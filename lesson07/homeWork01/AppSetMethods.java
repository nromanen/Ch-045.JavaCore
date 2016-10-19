package lesson07.homeWork01;

import java.util.HashSet;
import java.util.Set;

/* Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2), realizing the 
 * operations of union and intersection of two sets. Test the operation of these techniques on two 
 * pre-filled sets. 
 */

public class AppSetMethods {
	public static void main(String[] args) {

		Set<String> myHashSet1 = new HashSet<>();
		myHashSet1.add("dog");
		myHashSet1.add("cat");
		myHashSet1.add("parrot");
		myHashSet1.add("snake");
		myHashSet1.add("pig");
		System.out.println("Set1 includes: ");
		for (String set : myHashSet1) {
			System.out.print(set + "\t");
		}
		System.out.println("\n");

		Set<String> myHashSet2 = new HashSet<>();
		myHashSet2.add("dog");
		myHashSet2.add("swallow");
		myHashSet2.add("pinguin");
		myHashSet2.add("cat");
		myHashSet2.add("rabbit");
		myHashSet2.add("parrot");
		System.out.println("Set2 includes: ");
		for (String set : myHashSet2) {
			System.out.print(set + "\t");
		}
		System.out.println("\n");

		System.out.println("Union of two sets includes: " + SetMethods.union(myHashSet1, myHashSet2));

		System.out.println("Intersection of two sets includes: "+ SetMethods.intersection(myHashSet1, myHashSet2));
	}
}
