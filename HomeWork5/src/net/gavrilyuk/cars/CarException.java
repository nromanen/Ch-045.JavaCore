package net.gavrilyuk.cars;

/**
 * Car class  Exception
 * Created by Igor Gavrilyuk on 16.10.2016.
 */
public class CarException extends IllegalArgumentException {

    private int errCode;

    public CarException(int errCode, String s) {
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
