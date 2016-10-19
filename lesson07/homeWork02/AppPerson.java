package lesson07.homeWork02;

import java.util.TreeMap;

/* Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
Output the entities of the map on the screen. 
There are at less two persons with the same firstName among these 10 people?
Remove from the map person whose firstName is ”Orest” (or other). Print result.  
 */

public class AppPerson {

	public static void main(String[] args) {
		Person person = new Person();
		TreeMap<String, String> personMap = new TreeMap<>();

		person.setTreeMap(personMap);
		person.printMap(personMap);

		System.out.println("\n" + "There are at less two persons with the same firstName: "
				+ person.getSameValue(personMap) + "\n");

		System.out.println("\n"+"deleted value Alice from the map:");
		person.removeValue(personMap, "Alice");
		person.printMap(personMap);

	}

}
