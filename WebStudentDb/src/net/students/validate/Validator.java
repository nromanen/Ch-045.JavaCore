
package net.students.validate;

import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;

/**
 * Validator class
 * Created by Igor Gavryliuk on 05.11.2016.
 */
public class Validator {

    public static final String ERROR_KEY = "errorString";

    // performs simple validation on checkout form
    public boolean validateForm(String firstName, String lastName, String dateOfBirth,
                                String testBookNumber, String groupId, HttpServletRequest request ) {
        boolean errorFlag = false;
        if (firstName == null || firstName.isEmpty()||firstName.length()>50 ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid First Name!");
        }
        if (lastName == null || lastName.isEmpty()||lastName.length()>200 ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid Last Name!");
        }
        if (groupId == null || groupId.isEmpty() ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid Group iD!");
        }
        if (testBookNumber == null || testBookNumber.isEmpty() ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid test Book Number!");
        }
        if (dateOfBirth == null || dateOfBirth.isEmpty() ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid date Of Birth! Use format: yyyy-MM-dd");
        } else {
            try {
                DateTime dateTime = DateTime.parse(dateOfBirth);
            } catch (IllegalArgumentException e) {
                errorFlag = true;
                System.out.println(e.getMessage());
                request.setAttribute(ERROR_KEY, e.getMessage());
            }
        }
        return errorFlag;
    }

    public boolean validateFormMentor(String firstName, String lastName,
                                 HttpServletRequest request  ) {
        boolean errorFlag = false;
        if (firstName == null || firstName.isEmpty()||firstName.length()>50 ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid First Name!");
        }
        if (lastName == null || lastName.isEmpty()||lastName.length()>200 ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid Last Name!");
        }

        return errorFlag;
    }

    public boolean validateFormGroup(String title, String mentorId,  HttpServletRequest request  ) {
        boolean errorFlag = false;
        if (title == null || title.isEmpty()||title.length()>250 ) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid title!");
        }
        if (mentorId == null || mentorId.isEmpty()) {
            errorFlag = true;
            request.setAttribute(ERROR_KEY, "Invalid mentor!");
        } else {
            try {
                int i = Integer.parseInt(mentorId);
            } catch (NumberFormatException e) {
                errorFlag = true;
                System.out.println(e.getMessage());
                request.setAttribute(ERROR_KEY, e.getMessage());
            }
        }
        return errorFlag;
    }


}