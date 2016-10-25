package lesson09.practicaltask02;

public class Plant {

	private Type type;
	private Color color;
	private int size;

	public Plant(String type, String color, int size) throws ColorException, TypeException {
		Color c = colorStrToEnum(color);
		Type t = typeStrToEnum(type);
		this.size=size;
		this.type=t;
		this.color=c;
	}

	private Color colorStrToEnum(String color) throws ColorException {
		switch (color.toLowerCase()) {
		case "blue":
			return Color.BLUE;
		case "red":
			return Color.RED;
		case "white":
			return Color.WHITE;
		default:
			throw new ColorException("Input only color blue, red or white");
		}
	}

	private Type typeStrToEnum(String type) throws TypeException {
		switch (type) {
		case "rose":
			return Type.ROSE;
		case "cornflower":
			return Type.CORNFLOWER;
		case "chamomile":
			return Type.CHAMOMILE;
		default:
			throw new TypeException("Input only type rose, cornflower or chamomile");
		}
	}


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Plant [type=" + type + ", color=" + color + ", size=" + size + "]";
	}

	
	
}
