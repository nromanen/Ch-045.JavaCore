import java.util.Scanner;
//import java.lang.Math;
public class HomeWork { 
	
	 private static Scanner sc;

	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
	
		System.out.println("������ ������ ���������� :");
		int i = sc.nextInt();
		int dir = 2 * i;
		double S = (double) (Math.PI * Math.pow(i, 2));  
		
		System.out.println("������ ����� = " + dir);
		System.out.println("������� ���� = " + String.format("%(.2f", S));
	}

}
