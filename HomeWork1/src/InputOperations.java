import java.util.Scanner;

public class InputOperations {String message;

	InputOperations(String m){
		message = m;
	}
	InputOperations(){
	}
	
	public String inputString(){
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		String value = input.next();
		
		return value;
		
	}
	
	public int inputInt(){
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		int value = input.nextInt();
		
		return value;
		
	}
	
	public double inputDouble(){
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		double value = input.nextDouble();
		
		return value;
		
	}
	
}
