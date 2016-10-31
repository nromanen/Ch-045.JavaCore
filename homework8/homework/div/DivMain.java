package homework8.homework.div;

/**
 * Created by roma on 29.10.2016.
 * Create method div(), which calculates the dividing of two double numbers.
 * In main method input 2 double numbers and call this method. Catch all exceptions.

 */
public class DivMain {
    public static void main(String[] args){

        double a = DivUtils.readDoubleVal();
        double b = DivUtils.readDoubleVal();

        try{
            System.out.println(DivUtils.getDiv(a, b));
        } catch (ArithmeticException ae){
            System.out.print(ae);
        }
    }
}
