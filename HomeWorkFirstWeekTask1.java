
public class HomeWorkFirstWeekTask1 {
	
	
	
	

	public static void main(String[] args) {
		double radius = 4.5;

		System.out.printf("Flower's area with radius  " + radius + " is: " + "'%.4f'",Area(radius));
		System.out.println(" ");
		System.out.printf("Flower's perimeter with radius  " + radius + " is: " + "'%.4f'",Perimeter(radius));
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
