
public class Circle {double radius;

	Circle(double r){
		radius = r;
	}
	
	public double findPerimetr(){
		
		return  2 * radius *  Math.PI;
		
	}
	
	public double findArea(){
		
		return  Math.PI * radius * radius;
		
	}
}
