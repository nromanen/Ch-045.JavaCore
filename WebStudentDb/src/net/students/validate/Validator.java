
package net.students.validate;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

/**
 * Validator class
 * Created by Igor Gavryliuk on 05.11.2016.
 */
public class Validator {

    public static final int MAX_LAST_NAME = 200;
    public static final int MAX_FIRST_NAME = 200;

    // performs simple validation on student edit form
    public boolean validateForm(String firstName, String lastName, String dateOfBirth,
                                String testBookNumber,  HttpServletRequest request ) {
        boolean errorFlag = false;

        if (firstName == null || firstName.isEmpty() || firstName.length() > MAX_FIRST_NAME) {
            errorFlag = true;
            request.setAttribute("firstNameError", true);
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > MAX_LAST_NAME) {
            errorFlag = true;
            request.setAttribute("lastNameError", true);
        }
        if (testBookNumber == null || testBookNumber.isEmpty() ) {
            errorFlag = true;
            request.setAttribute("testBookNumberError", true);
        }
        if (dateOfBirth == null || dateOfBirth.isEmpty() ) {
            errorFlag = true;
            request.setAttribute("dateOfBirthError", true);
        } else {
            try {
                DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
                DateTime dateTime = DateTime.parse(dateOfBirth, fmt);
                if (dateTime.isAfterNow()) {
                    throw new IllegalArgumentException("Future date!");
                }
            } catch (IllegalArgumentException e) {
                errorFlag = true;
                System.out.println(e.getMessage());
                request.setAttribute("dateOfBirthError", true);
            }
        }
        return errorFlag;
    }
    //mentor edit
    public boolean validateFormMentor(String firstName, String lastName,  HttpServletRequest request ) {
        boolean errorFlag = false;

        if (firstName == null || firstName.isEmpty() || firstName.length() > MAX_FIRST_NAME) {
            errorFlag = true;
            request.setAttribute("firstNameError", true);
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > MAX_LAST_NAME) {
            errorFlag = true;
            request.setAttribute("lastNameError", true);
        }
        return errorFlag;
    }
    //group edit
    public boolean validateFormGroup(String title, HttpServletRequest request) {
        boolean errorFlag = false;
        if (title == null || title.isEmpty() ) {
            errorFlag = true;
            request.setAttribute("titleError", true);
        }
        return errorFlag;
    }
}