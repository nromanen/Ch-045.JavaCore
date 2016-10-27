package net.gavrilyuk.task1;

/**
 * Rectangle Class
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class Rectangle {

    private int a;
    private int b;


    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(int a, int b) throws RectangleSideException {
        if (a < 0 ) throw new RectangleSideException(1, "The side \'a\' of the rectangle can't be negative");
        if (b < 0 ) throw new RectangleSideException(1, "The side \'b\' of the rectangle can't be negative");
        this.a = a;
        this.b = b;
    }

    public long square()  {
        return this.a * this.b;
    }

    public long perimeter() {
        return (this.a + this.b) * 2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) throws RectangleSideException {
        if (a < 0 ) throw new RectangleSideException(1, "The side \'a\' of the rectangle can't be negative");
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) throws RectangleSideException {
        if (b < 0 ) throw new RectangleSideException(1, "The side \'b\' of the rectangle can't be negative");
        this.b = b;
    }
}
