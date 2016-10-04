
public class PersonalDetails {
	String name;
	int age;
	String address;
	
	public void displayInformation(){
		
		System.out.println("Personal details:");
		System.out.println("Name: " + name + ";");
		System.out.println("Age: " + age + ";");
		System.out.println("Address: " + address + ";");
	}
	
	public void fillDetails(){
		
		InputOperations input = new InputOperations("What is your name?");
		name = input.inputString();
		
		input.message = "How old are you, " + name;
		
		age = input.inputInt();
		
		input.message = "Where are you live, " + name;
		
		address = input.inputString();
		
	}

}
