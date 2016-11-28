package com.ariezz.validator;

/**
 * Created by Admin on 12.11.16.
 */
public class ValidateEmployeeErrors {

    private String fNameError;
    private String lNameError;
    private String ssnError;
    private String emailError;
    private String bDayError;
    private String charactError;
    private String rateError;


    public String getfNameError() {
        return fNameError;
    }

    public void setfNameError(String fNameError) {
        this.fNameError = fNameError;
    }

    public String getlNameError() {
        return lNameError;
    }

    public void setlNameError(String lNameError) {
        this.lNameError = lNameError;
    }

    public String getSsnError() {
        return ssnError;
    }

    public void setSsnError(String ssnError) {
        this.ssnError = ssnError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getbDayError() {
        return bDayError;
    }

    public void setbDayError(String bDayError) {
        this.bDayError = bDayError;
    }

    public String getCharactError() {
        return charactError;
    }

    public void setCharactError(String charactError) {
        this.charactError = charactError;
    }

    public String getRateError() {
        return rateError;
    }

    public void setRateError(String rateError) {
        this.rateError = rateError;
    }

    @Override
    public String toString() {
        return "ValidateEmployeeErrors{" +
                "fNameError='" + fNameError + '\'' +
                ", lNameError='" + lNameError + '\'' +
                ", ssnError='" + ssnError + '\'' +
                ", emailError='" + emailError + '\'' +
                ", bDayError='" + bDayError + '\'' +
                ", charactError='" + charactError + '\'' +
                ", rateError='" + rateError + '\'' +
                '}';
    }
}
