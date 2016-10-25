package net.gavrilyuk.exceptions;

import java.util.Date;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public class InvalidDateException extends IllegalArgumentException {

    private Date invalidDate;

    public InvalidDateException(Date invalidDate, String s) {
        super(s);
        this.invalidDate = invalidDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    @Override
    public String toString() {
        return "invalidDate=" + invalidDate +" : "+this.getMessage();
    }
}
