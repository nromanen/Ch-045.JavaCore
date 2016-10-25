package lesson09.practicaltask01;

public class Rectangle extends Shape{
	private int width;
	private int length;

	public Rectangle() {

	}

	public Rectangle(String name, int width, int length) {
		super(name);
		this.width=width;
		this.length=length;
	}
	
	
	@Override
	public int perimeter() throws Exception{
		if(width<=0|length<=0) throw new Exception();
		return (width + length) * 2;
		
	}

	@Override
	public int area() throws Exception {
		if(width<=0|length<=0) throw new Exception();
		return width * length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		int temp1 = 0;
		int temp2 = 0;
		try{
			temp1=perimeter();
			temp2=area();
		} catch(Exception e){
			e.printStackTrace();
		}
		return "Shape: "+getName()+"; width=" + width + "; length=" + length + "; perimeter=" + temp1 + ", area="
				+ temp2;
	}

	
}
