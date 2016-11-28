package com.ariezz.validator;

import com.ariezz.model.Employee;
import com.ariezz.util.GetEmployee;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 10.11.16.
 */
public class EmployeeValidator {

    private final int MIN = 2;
    private final int MAX = 20;
    private final int SSNMIN = 100000;
    private final int SSNMAX = 999999;
    private final int MAXEMAIL = 65;
    private final String oldestBDay = "1930-01-01";

    private boolean isValid = true;
    private  Date oldestEmployeeBDay;



    private ValidateEmployeeErrors errors = new ValidateEmployeeErrors();

    public ValidateEmployeeErrors getErrors() {
        return errors;
    }

    private void setOldest(){
        try {
            this.oldestEmployeeBDay = new  SimpleDateFormat("yyyy-MM-dd").parse(oldestBDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public ValidateEmployeeErrors validate(HttpServletRequest req){

        setOldest();

        Employee employee = GetEmployee.getEmployeeFromReq(req);

        if (employee.getFirstName().isEmpty()){
            errors.setfNameError("First name cant be empty!");
            isValid = false;
        } else if (employee.getFirstName().length() < MIN || employee.getFirstName().length() > MAX){
            errors.setfNameError("Length of first name should be between " + MIN + " and " + MAX + " letters");
            isValid = false;
        }

        if (employee.getLastName().isEmpty()){
            errors.setlNameError("Last name cant be empty!");
            isValid = false;
        } else if (employee.getLastName().length() < MIN || employee.getLastName().length() > MAX){
            errors.setlNameError("Length of last name should be between " + MIN + " and " + MAX + " letters");
            isValid = false;
        }

        if (employee.getEmail().isEmpty()){
            errors.setEmailError("Email cant be empty!");
            isValid = false;
        } else if (employee.getEmail().length() > MAX){
            errors.setlNameError("Length of email should be less than " + MAXEMAIL+ " letters");
            isValid = false;
        }

        if(employee.getCharacteristic().isEmpty()){
            errors.setCharactError("Characteristic of employee should be entered");
            isValid = false;
        }

        if (employee.getSSN() < SSNMIN || employee.getSSN() > SSNMAX){
            errors.setSsnError("The SSN number should contains 6 digits");
            isValid = false;
        }

        if (employee.getRate() == 0 ){
            errors.setRateError("Enter the rate of employee");
            isValid = false;
        } else if (employee.getRate() < 0){
            errors.setRateError("Rate cant be negative");
            isValid = false;
        }

        if (employee.getbDay() == null){
            errors.setbDayError("Incorrect birth day. Enter the birth day in format yyyy-MM-dd");
            isValid = false;
        } else if (!employee.getbDay().before(new Date())){
            errors.setbDayError("Birth day cant be in future");
            isValid = false;
        } else if (employee.getbDay().before(oldestEmployeeBDay)){
            errors.setbDayError("To old Employee");
            isValid = false;
        }

        return errors;
    }

    public boolean isValid() {
        return isValid;
    }
}
