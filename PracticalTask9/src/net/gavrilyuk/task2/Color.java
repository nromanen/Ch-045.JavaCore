package net.gavrilyuk.task2;

/**
 * Plants Color
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public enum Color {


    RED(255, 0, 0) ,
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0),
    CUSTOM(0, 0, 0);

    private int red;
    private int green;
    private int blue;

    //The three arguments must each be in the range 0-255.
    Color(int red, int green, int blue) throws ColorException {
        if (red < 0 || red > 255) throw new ColorException("red");
        if (green < 0 || green > 255) throw new ColorException("green");
        if (blue < 0 || blue > 255) throw new ColorException("blue");
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(int red) throws ColorException {
        if (red < 0 || red > 255) throw new ColorException("red");
        this.red = red;
    }

    public void setGreen(int green) throws ColorException {
        if (green < 0 || green > 255) throw new ColorException("green");
        this.green = green;
    }

    public void setBlue(int blue) throws ColorException {
        if (blue < 0 || blue > 255) throw new ColorException("blue");
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getRGB() {
        return red + "," + green + "," + blue;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + getRGB() + ")";
    }
}
