
public class HomeWorkFirstWeekTask1 {
	
	
	
	

	public static void main(String[] args) {
		double radius = 4.3;

		System.out.printf("������� ����� � �������� " + radius + " = " + "'%.4f'",Area(radius));
		System.out.println(" ");
		System.out.printf("�������� ����� � �������� " + radius + " = " + "'%.4f'",Perimeter(radius));
	}

	private static double Area(double radius) {

		double area = Math.PI * (radius * radius);
		return area;
	}

	private static double Perimeter(double radius) {

		double perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

}
