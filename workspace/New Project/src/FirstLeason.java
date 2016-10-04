import java.util.Scanner;
public class FirstLeason {
	
	private static Scanner sc;
	static int c;

	public static void main(String[] args)
	{
	int a, b;
		  sc = new Scanner(System.in); 
		
		System.out.println("введите первое число:");
		a = sc.nextInt();
		System.out.println("введите второе число:");
		b = sc.nextInt();
		c = a + b; 
		System.out.println("сумма ваших чисел = "+ c);
		c = a - b;
		System.out.println("разница ваших чисел = "+ c);
		c = a * b;
		System.out.println("умножение ваших чисел = "+ c);
		if (b == 0) {
			System.out.println("Деление:на 0 делить нельзя ");	
		}else {
		double c1 = a / b;
		System.out.println("деление ваших чисел = "+ c1);
		}
		
		}
		
	}


