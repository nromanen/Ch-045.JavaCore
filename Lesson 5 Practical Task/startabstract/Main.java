package startabstract;

import java.util.ArrayList;
/*Create next structure. In abstract class Person with property name, 
declare abstract method print(). In other classes in body of method print()
output text “I am a …”. In class Staff declare abstract method salary().
 In each concrete class create constant TYPE_PERSON. Output type of person in each 
 constructors. Create array of Person and add some Teachers, Cleaners and Students to it.
 Call method print() for all of it. Call method salary() for all Teachers and Cleaner
public class Main {
*/
public class Main {

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				persons.add(new Cleaner());
			} else if (i % 3 == 0) {
				persons.add(new Teacher());
			} else
				persons.add(new Student());
		}
		for (Person person : persons) {
			person.print();
			if (person instanceof Staff) {
				((Staff) person).salary();
			}
		}
	}

}
