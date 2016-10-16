package homework2ndtask;

public class SalariedEmployee extends Employee implements calculatePay {
	private String name;
	
	double salary = 3000;
	
	private  String socialSecurityNumber = name + counter;

	public SalariedEmployee() {

	}

	public SalariedEmployee(String name, double rate) {
this.name = name;
this.salary = salary*rate;
counter++;
	}

	@Override
	public double calculatePay() {
return salary;
	}

	@Override
	public String toString() {
		return name + " has ID : " + socialSecurityNumber + ", receives salary " + this.salary;
	}

}
