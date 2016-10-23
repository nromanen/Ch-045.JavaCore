package util;

/**
 * Created by Admin on 06.10.16.
 */
public class Print {

    public static void print( Object... data){
        StringBuilder sb = new StringBuilder("");

        for (Object item : data){
            sb.append(item);
        }

        System.out.print(sb.toString());

    }

    public static void println( Object... data){

        StringBuilder sb = new StringBuilder("");

        for (Object item : data){
            sb.append(item);
        }

        System.out.println(sb.toString());

    }
}
