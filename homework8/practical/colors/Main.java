package homework8.practical.colors;

/**
 * Created by roma on 28.10.2016.
 * Create a class Plants, which includes fields int size, Color color and Type type,
 * and constructor where these fields are initialized. Color and type are Enum.
 * Override the method toString( ).
 * Create classes ColorException and TypeException and describe there all possible colors and types of plants.
 * In the method main create an array of five plants. Check to work your exceptions.

 */
public class Main {
    public static void main(String[] args) {
        try {
            Plant pl = new Plant("Type1", "blue3", 5);
            System.out.println(pl);
        } catch (TypeException te) {
            System.out.println(te);
            //e.printStackTrace();
        } catch (ColorException ce) {
            System.out.println(ce);
            //e.printStackTrace();
        }
    }
}
