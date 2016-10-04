import java.util.Scanner;

public class HomeWork_task2 {
	
	private static Scanner sc;
	
	public static void main(String[] args)

	{
		sc = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String name = sc.nextLine();
	
		System.out.println("How old are u, " + name +"?");
		
		int age = sc.nextInt();
					
		System.out.println("Where are u leave, " + name +"?");
		sc.nextLine();	
		String sity = sc.nextLine();	
			
		System.out.println("your name is:" + name);
		System.out.println("your age is:" + age);
		System.out.println("you leave in:" + sity);
	

	}
}
