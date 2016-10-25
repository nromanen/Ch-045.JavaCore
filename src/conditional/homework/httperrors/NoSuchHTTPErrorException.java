package conditional.homework.httperrors;

/**
 * Created by Admin on 24.10.16.
 */
public class NoSuchHTTPErrorException extends Exception {
    public NoSuchHTTPErrorException(){
        super("No Such HTTPError!");
    }
}
