package net.gavrilyuk.task2;

/**
 * Color Exception
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class ColorException extends IllegalArgumentException {

    private int errCode;

    public ColorException( int errCode, String badColor) {
        super("Color parameter outside of expected range 0-255:" + badColor);
        this.errCode = errCode;
    }


    public ColorException(String badColor) {
        this(0, badColor);
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
