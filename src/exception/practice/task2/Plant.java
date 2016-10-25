package exception.practice.task2;


public class Plant {
    private int size;
    private Color color;
    private Type type;

    public Plant(int size, Color color, Type type) {
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;

        Plant plants = (Plant) o;

        if (getSize() != plants.getSize()) return false;
        if (getColor() != plants.getColor()) return false;
        return getType() == plants.getType();

    }

    @Override
    public int hashCode() {
        int result = getSize();
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plant{" + "type=" + type + ", size=" + size + ", color=" + color + "}";
    }
}
