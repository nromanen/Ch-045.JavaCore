package net.gavrilyuk.task1;

/**
 * Rectangle Exception
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class RectangleSideException extends NumberFormatException {

    private int errorCode;

    public RectangleSideException(int errorCode, String s) {
        super(s);
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
