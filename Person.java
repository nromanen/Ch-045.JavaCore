package personhomeworkweek2;

import java.util.Calendar;

public class Person {
	private String name;
	private int birthYear;
	private int birthMonth;
	private int birthDate;
	private int age;
	public static int count = 0;
	int id;

	public static void main(String[] args) {

		/*
		 * Calendar rightNow = Calendar.getInstance(); int year =
		 * rightNow.get(rightNow.YEAR); int month =
		 * rightNow.get(rightNow.MONTH); int date = rightNow.get(rightNow.DATE);
		 */
		Person person1 = new Person();
		person1.input("Ivan Mikhailovich", 1933, 06, 15);

		System.out.println(person1.output());
		Person per2 = new Person("Oleg Petrov", 1980, 02, 13);
		System.out.println(per2.output());
		Person per3 = new Person("Vasya Pupkin", 2000, 10, 05);
		System.out.println(per3.output());
		Person per4 = new Person("Stepan Dulin", 1970, 01, 01);
		System.out.println(per4.output());
		Person p5 = new Person("Kolia Zenin", 1987, 12, 30);
		System.out.println(p5.output());
		// System.out.println("new name for person # 5 - " +
		// p5.changeName("Zavadskii Ivan");
		// System.out.println("new worker: " + p5.output() + "check ID!!");
		// System.out.println(p5.age());
	}

	public Person() {
		id = count;
		count++;
	}

	public Person(String name, int birthYear, int birthMonth, int birthDate) {
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;
		id = count;
		count++;
	}

	public void input(String name, int birthYear, int birthMonth, int birthDate) {
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;

	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int age() {
		
		Calendar rightNow = Calendar.getInstance();
		int year = rightNow.get(rightNow.YEAR);
		int month = rightNow.get(rightNow.MONTH);
		int date = rightNow.get(rightNow.DATE);
		int OLDage = year - this.birthYear;
		if (this.birthMonth > month) {
			OLDage = OLDage - 1;
		} else if (this.birthMonth == month && this.birthDate > date) {
			OLDage = OLDage - 1;
		} else if (this.birthMonth == month && this.birthDate == date) {
			System.out.println("Happy" + age + " 's Birthday");
		}
		
		return OLDage;
	}

	public void setAge(int OLDage) {
		this.age = OLDage;
	}

	public String changeName(String name) {
		return this.name = name;
	}

	public String output() {

		return "Person [name=" + name + ", age = " + age() + " and has ID : " + id + "]";
	}
}
