import java.util.Scanner;

public class HomeWork_Task3 {

	private static Scanner sc;
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		 int s1 = 10, s2 = 15, s3 = 23;
		  System.out.println("¬ведите продолжительность времени первого разговора ");
		   int t1 = sc.nextInt();
		  System.out.println("¬ведите продолжительность времени второго разговора ");
			int t2 = sc.nextInt();
			 System.out.println("¬ведите продолжительность времени третьего разговора ");
			int t3 = sc.nextInt();
			
			int[] ArrayOfTime = {t1,t2,t3};
			
			for(int i=0; i<=2; i++) {
				
				int cost1 = s1 * ArrayOfTime[i], 
					cost2 = s2 * ArrayOfTime[i], 
					cost3 = s3 * ArrayOfTime[i], 
					cost_all = cost1 + cost2 + cost3;
					 
					System.out.println("—тоимость разговра  с первой страной :" + cost1);
					System.out.println("—тоимость разговра  с второй страной :" + cost2);
					System.out.println("—тоимость разговра  с третьей страной :" + cost3);
					System.out.println("ќбща€ стоимость разговоров :" + cost_all);
			}
	
	}

}
