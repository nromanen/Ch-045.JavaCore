package net.gavrilyuk.task2;

/**
 *  Type Exception
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class  TypeException extends IllegalArgumentException {

    private int errCode;

    public TypeException(int errCode, String s ) {
        super(s);
        this.errCode = errCode;
    }

    public TypeException(String message) {
        this(0, message);
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
