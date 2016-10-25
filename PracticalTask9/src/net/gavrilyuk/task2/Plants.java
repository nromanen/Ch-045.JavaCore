package net.gavrilyuk.task2;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Plants {

    private int size;
    private Color color;
    private Type type;

    public Plants() {
    }

    public Plants(int size, Color color, Type type) throws ColorException, TypeException{
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public void setSize(int size) throws IllegalArgumentException {
        if (size<0) throw new NumberFormatException("Plats size must be >0 !");
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setColor(Color color) throws ColorException {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Plants{" + "size=" + size +", color=" + color + ", type=" + type +'}';
    }
}
