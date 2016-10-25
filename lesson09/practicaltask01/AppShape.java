package lesson09.practicaltask01;

public class AppShape {
public static void main(String[] args) {
	UtilShape util=new UtilShape();
	Rectangle shape=new Rectangle();
	System.out.println("Please, input name of the shape: ");
	shape.setName(util.inputString());
	System.out.println("Please, input width of the shape(integer number): ");
	shape.setWidth(util.inputInt());
	System.out.println("Please, input length of the shape(integer number): ");
	shape.setLength(util.inputInt());
	System.out.println(shape.toString());
	
	
}
}
