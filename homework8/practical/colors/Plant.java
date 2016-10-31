package homework8.practical.colors;

/**
 * Created by roma on 28.10.2016.
 */
public class Plant {
    private Type type;
    private Color color;
    private int size;

    public Plant() {
    }

    public Plant(String type, String color, int size) throws ColorException, TypeException {
        Color c = colorStrToEnum(color);
        Type t = typeStrToEnum(type);
        this.size = size;
        this.type = t;
        this.color = c;
    }

    private Color colorStrToEnum(String color) throws ColorException {
        switch (color.toLowerCase()) {
            case "blue":
                return Color.Blue;
            case "red":
                return Color.Red;
            case "white":
                return Color.White;
            default:
                throw new ColorException(color);
        }
    }

    private Type typeStrToEnum(String type) throws TypeException{
        switch (type.toLowerCase()){
            case "type1":
                return Type.Type1;
            case "type2":
                return Type.Type2;
            case "type3":
                return Type.Type3;
            default:
                throw new TypeException(type);
        }
    }

    @Override
    public String toString() {
        return "Plant -> " +
                "type=[" + type +
                "], color=[" + color +
                "], size=[" + size +
                "]";
    }
}
