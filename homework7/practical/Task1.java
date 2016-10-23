package homework7.practical;

/**
 * Created by roma on 21.10.2016.
 * Enter the two variables of type String. Determine whether the first variable substring second.
 * For example, if you typed «IT» and «IT Academy» you must receive true.

 */
public class Task1 {
    public static void main(String[] args){
        String variable1 = "IT";
        String variable2 = "IT Academy";

        System.out.println(Utils.isContains(variable1, variable2) ? "contains" : "not contains");
    }
}
