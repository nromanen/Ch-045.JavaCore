
public class Task {
	
	public void startTask(){
		
		InputOperations input = new InputOperations("Enter number of task");
		int numberOfTasks = input.inputInt();
		
		input.message = "Enter radius: ";
		
		switch (numberOfTasks){
		case 1:
			
			Circle task = new Circle(input.inputDouble());
			
			System.out.println("Perimetr is :" + task.findPerimetr());
			System.out.println("Area is :" + task.findArea());

		case 2:
			PersonalDetails person = new PersonalDetails();
			
			person.fillDetails();
			person.displayInformation();

		
		case 3:
			Country country = new Country();
			
			country.makeCall();
		
		default :
			System.out.println("Not found such task!");
		}
	}
}
