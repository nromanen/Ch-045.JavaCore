package personhomeworkweek2;

public class Person {
	private String name;
	private int birthYear;
	int age;
	public static int count = 0;
	int id;
	
	public static void main(String[] args) {
		Person person1 = new Person();
		person1.input("Ivan Mikhailovich", 1933);
		
		System.out.println(person1.output());
		Person per2 = new Person("Oleg Petrov", 1980);
		System.out.println(per2.output());
		Person per3 = new Person("Vasya Pupkin", 2000);
		System.out.println(per3.output());
		Person per4 = new Person("Stepan Dulin", 1970);
		System.out.println(per4.output());
		Person p5 = new Person("Kolia Zenin", 1987);
		System.out.println(p5.output());
		// System.out.println("new name for person # 5 - " +
		 p5.changeName("Zavadskii Ivan");
		 System.out.println("new worker: " + p5.output() + "check ID!!");
		System.out.println(p5.age());
	}

	

	public Person() {
		id = count;
		count++;
	}

	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		id = count;
		count++;
	}

	public void input(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		 
		
	}

	public int age(){
	return age = 2016 - this.birthYear;}

	public String changeName(String name) {
		return this.name = name;
	}

	public String output() {
		int age = 2016 - this.birthYear;
		return "Person [name=" + name + ", age=" + age + " and has ID : " + id + "]";
	}
}
