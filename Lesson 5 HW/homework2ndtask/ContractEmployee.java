package homework2ndtask;

public class ContractEmployee extends Employee implements calculatePay {
	private String name;
	private String federalTaxIdmember =  name + counter;
	private int hours = 8*5*4;//HOURS PER MONTH
	private double salary;
	
	public ContractEmployee(String name)
	{
		this.name = name;
	}
	public ContractEmployee(String name, double rate)
	{
		this.name = name;
		this.salary = hours*rate;
		counter++;
	}
	
	@Override
	public double calculatePay() {
		return salary;

	}
	
	
	public String toString()
	{
		return name + " has ID : " + federalTaxIdmember + ", receives salary " + this.salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
