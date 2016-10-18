package net.gavtilyuk.task3;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class StudentException extends IllegalArgumentException {

    private int errCode;

    public StudentException(int errCode, String s) {
        super(s);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "errCode=" + errCode +" : "+this.getMessage();
    }

}
