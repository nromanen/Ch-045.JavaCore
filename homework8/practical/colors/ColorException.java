package homework8.practical.colors;

/**
 * Created by roma on 28.10.2016.
 */
public class ColorException extends Exception{

    private String color;

    public ColorException() {
    }

    public ColorException(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorException color=" + color
                + "\nChose [White, Red, Blue]";
    }
}
