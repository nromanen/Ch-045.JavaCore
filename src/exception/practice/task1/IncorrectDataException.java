package exception.practice.task1;

/**
 * Created by Admin on 23.10.16.
 */
public class IncorrectDataException extends Exception {

    public IncorrectDataException(){
        super();
    }

    public IncorrectDataException(String message){
        super(message);
    }
}
