import java.util.Scanner;

public class Homework_Task_3 {

	private static final int[] ArrayOfRates = null;
	private static Scanner sc;

	
	public static void main(String[] args)
	{
		Homework_Task_3.Rates();
	}
	
	// ��������� ��������� ����������
	public static void Rates()
	{
		sc = new Scanner(System.in);
		City nCity = new City();
		int Rates[] =  nCity.GetRrates(ArrayOfRates);
		
		  System.out.println("������� ����������������� ������� ������� ��������� ");
		  int t1 = sc.nextInt();
		  System.out.println("������� ����������������� ������� ������� ��������� ");
		  int t2 = sc.nextInt();
		  System.out.println("������� ����������������� ������� �������� ��������� ");
		  int t3 = sc.nextInt();
			
		  int[] ArrayOfTime = {t1,t2,t3};
			
			for(int i=0; i<=2; i++) {
				
				int cost1 = Rates[0] * ArrayOfTime[i], 
					cost2 = Rates[1] * ArrayOfTime[i], 
					cost3 = Rates[2] * ArrayOfTime[i], 
					cost_all = cost1 + cost2 + cost3;
					 
					System.out.println("��������� ��������  � ������ ������� :" + cost1);
					System.out.println("��������� ��������  � ������ ������� :" + cost2);
					System.out.println("��������� ��������  � ������� ������� :" + cost3);
					System.out.println("����� ��������� ���������� :" + cost_all);
			}
	}
}
