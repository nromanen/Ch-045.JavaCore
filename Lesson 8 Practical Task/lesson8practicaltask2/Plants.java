package lesson8practicaltask2;

public class Plants {
	private int size;
	private Colour colour;
	private Type type;

	public Plants(Type type, int size, Colour colour) {
		this.size = size;
		this.colour = colour;
		this.type = type;

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Plant type -" + getType() + ", size - " + getSize() + ", colour -" + getColour();
	}

}
