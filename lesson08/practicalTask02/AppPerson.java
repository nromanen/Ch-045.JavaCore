package lesson08.practicalTask02;

/* Enter surname, name and patronymic on the console as a variable of type String. Output on the console:
1) surnames and initials;
2) name;
3) name, middle name and last name; 
 */
public class AppPerson {
	public static void main(String[] args) {
		Person person = new Person();
		PersonUtil personUtil = new PersonUtil();
		System.out.println("Please input person's surname:");
		person.setSurname(personUtil.inputString());
		System.out.println("Please input person's name:");
		person.setName(personUtil.inputString());
		System.out.println("Please input person's patronymic");
		person.setPatronymic(personUtil.inputString());
		System.out.println("Person's  surnames and initials are: "
				+ personUtil.outputSurname(person.getSurname(), person.getName(), person.getPatronymic()));
		System.out.println("Person's name are: " + personUtil.outputName(person.getName()));
		System.out.println("Person's name, middle name and last name are: "
				+ personUtil.outputPersonData(person.getSurname(), person.getName(), person.getPatronymic()));

	}
}
