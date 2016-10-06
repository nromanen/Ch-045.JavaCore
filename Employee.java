
public class Employee {
	private String name;
	private int hours;
	private double rate;
	static int totalSum;
	public double bonuses;

	public Employee() {
		totalSum++;
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("Vasya");
		emp1.rate = 3.3;
		emp1.hours = 12;

		Employee emp2 = new Employee("Pupkin");
		emp2.rate = 4.0;
		emp2.hours = 10;

		Employee emp3 = new Employee("Lida Galustian");
		emp3.rate = 2.8;
		emp3.hours = 20;

		System.out.println("Total hours of all workers " + (emp1.hours + emp2.hours + emp3.hours));
		System.out.println("Salary of 1st Employee is " + emp1.salary() + "and bonuses " + emp1.bonuses());
		System.out.println("Salary of 2nd Employee is " + emp2.salary());
		System.out.println("Salary of 3rd Employee is " + emp3.salary());
		int total = emp1.salary() + emp2.salary() + emp3.salary();
		double totalBonuses = emp1.bonuses() + emp2.bonuses() + emp3.bonuses(); 
		System.out.println("Totatal money amount for salary: " + total + ", total bonuses amount: " + totalBonuses);
	}

	public Employee(String name) {
		this.name = name;
		totalSum++;
	}

	public Employee(String name, double rate) {
		this.name = name;
		this.rate = rate;
		totalSum++;
	}

	public Employee(String name, int hours, double rate) {
		this.name = name;
		this.rate = rate;
		this.hours = hours;
		totalSum++;
	}

	public String toString() {
		return "Student [name= " + name + ", rating= " + rate + ", hours=" + hours + "]";
	}

	public int salary() {
		int salary = (int) rate * hours;
		return salary;
	}

	public void changeRate(double rate) {
		this.rate = rate;
	}

	public double bonuses(){
	return	bonuses = this.salary() / 10;}

}
