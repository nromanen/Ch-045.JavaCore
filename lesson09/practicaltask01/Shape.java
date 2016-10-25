package lesson09.practicaltask01;


public abstract class Shape implements CalculationPerimeter, CalculationArea {
	
	private String name;

	public Shape() {

	}

	public Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
