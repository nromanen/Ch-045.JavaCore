package lesson08.practicalTask03;

import java.util.ArrayList;
import java.util.List;

/* The user name can be 3 to 15 characters of the Latin alphabet, numbers, and underscores. Using 
 * regular expressions implement checking the user name for validity. Input five names in the main method . 
 * Output a message to the console of the validation of each of the entered names. 
 */

public class AppName {
	public static void main(String[] args) {
		Name name1 = new Name("Anna-Maria");
		Name name2 = new Name("Oleksandr");
		Name name3 = new Name("Black-Jack");
		Name name4 = new Name("OJoejgtiorewhi");
		Name name5 = new Name("Ben");
		Name name6 = new Name("men-jewhgfiahi");

		List<Name> list = new ArrayList<>();
		list.add(name1);
		list.add(name2);
		list.add(name3);
		list.add(name4);
		list.add(name5);
		list.add(name6);
		for (Name in : list) {
			System.out.println(in);
		}

	}

}
