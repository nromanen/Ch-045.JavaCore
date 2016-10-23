package stringandregex.homework.task2;

public class Util {

    // Method replace 2 and more white spaces to one
    public static String removeWhitespaces(String sentence) {
        return sentence.trim().replaceAll("[\\s]{2,}", " ");
    }
}
