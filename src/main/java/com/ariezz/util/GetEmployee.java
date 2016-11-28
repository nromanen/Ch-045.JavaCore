package com.ariezz.util;

import com.ariezz.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Admin on 13.11.16.
 */
public class GetEmployee {



    public static Employee getEmployeeFromReq(HttpServletRequest req) {

        Employee employee = new Employee();

        try {
            employee.setFirstName(req.getParameter("firstName"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            employee.setLastName(req.getParameter("lastName"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            employee.setEmail(req.getParameter("email"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            employee.setCharacteristic(req.getParameter("char"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            employee.setSSN(Integer.parseInt(req.getParameter("ssn")));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        try {
            employee.setRate(Integer.parseInt(req.getParameter("rate")));
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        try {
            employee.setbDay(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bDay")).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
