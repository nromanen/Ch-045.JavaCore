
public class Task {
	
	public void startTask(){
		
		InputOperations input = new InputOperations("Enter number of task");
		int numberOfTasks = input.inputInt();
		
		input.message = "Enter radius: ";
		
		if (numberOfTasks == 1) {
			
			Circle task = new Circle(input.inputDouble());
			
			System.out.println("Perimetr is :" + task.findPerimetr());
			System.out.println("Area is :" + task.findArea());
		}
		else if (numberOfTasks == 2){
			PersonalDetails task = new PersonalDetails();
			
			task.fillDetails();
			task.displayInformation();
		}
		
		else if (numberOfTasks == 3){
			Country task = new Country();
			
			task.makeCall();
		}
		else {
			System.out.println("Not found such task!");
		}
	}
}
