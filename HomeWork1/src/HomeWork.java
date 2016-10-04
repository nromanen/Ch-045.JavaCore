
public class HomeWork {

	public static void main(String[] args) {

		try {
		Task task = new Task();
		
		task.startTask();
		}
		catch (ArithmeticException  e)  
			{System.out.println("Error with task");}

	}

}
