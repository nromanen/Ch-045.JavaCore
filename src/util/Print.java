package util;

/**
 * Created by Admin on 06.10.16.
 */
public class Print {

    public static void print( Object... data){
        String result = "";
        for (Object item : data){
            result += item;
        }

        System.out.print(result);

    }

    public static void println( Object... data){
        String result = "";
        for (Object item : data){
            result += item;
        }

        System.out.println(result);

    }
}
