import java.util.Scanner;
public class FirstLeason {
	
	private static Scanner sc;
	static int c;

	public static void main(String[] args)
	{
	int a, b;
		  sc = new Scanner(System.in); 
		
		System.out.println("������� ������ �����:");
		a = sc.nextInt();
		System.out.println("������� ������ �����:");
		b = sc.nextInt();
		c = a + b; 
		System.out.println("����� ����� ����� = "+ c);
		c = a - b;
		System.out.println("������� ����� ����� = "+ c);
		c = a * b;
		System.out.println("��������� ����� ����� = "+ c);
		if (b == 0) {
			System.out.println("�������:�� 0 ������ ������ ");	
		}else {
		double c1 = a / b;
		System.out.println("������� ����� ����� = "+ c1);
		}
		
		}
		
	}


