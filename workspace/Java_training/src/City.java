import java.util.Scanner;

public class City {
	private static Scanner sc;
// s1, s2, s3 - ������ ������� 1,2 � 3 
//	private  int s1, s2, s3;
 
	public int[] GetRrates (int[] Rates) 
	{
		sc = new Scanner(System.in); 
		System.out.println("������� ����� ������� s1,s2,s3");
		int	s1 = sc.nextInt();
		int	s2 = sc.nextInt();
		int	s3 = sc.nextInt();
		int ArrayOfRates[] ={s1,s2,s3}; 
	
		
		return ArrayOfRates; 
		  
	}
}
