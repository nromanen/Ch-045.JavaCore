package net.gavrilyuk.exceptions;

/**
 * Mentor Exception
 * Created by Igor Gavryliuk on 24.10.2016.
 *  errorCode:1 - invalid or empty fist name
 *  errorCode:2 - invalid or empty last name
 */
public class MentorException extends IllegalArgumentException {

    private int errorCode;

    public MentorException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "errCode=" + errorCode +" : "+this.getMessage();
    }
}
