package homework7.homework;

/**
 * Created by roma on 23.10.2016.
 * Enter a sentence that contains the words between more than one space.
 * Convert all spaces, consecutive, one. For example, if we introduce the sentence
 * "I    am      learning     Java   Core», we have to get the "I'm learning Java Core»

 */
public class Task2 {
    public static void main(String[] args){
        String str = "  I   live in      Ukraine  ";

        //convert all spaces to one
        System.out.println(Util.replaceAllSpace(str));
    }
}
