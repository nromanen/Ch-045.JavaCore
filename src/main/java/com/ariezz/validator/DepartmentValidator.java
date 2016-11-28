package com.ariezz.validator;

import com.ariezz.model.Department;
import com.ariezz.util.GetDepartment;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 13.11.16.
 */
public class DepartmentValidator {

    private final int MIN = 2;
    private final int MAX = 20;


    private boolean isValid = true;


    private ValidateDepartmentErrors errors = new ValidateDepartmentErrors();

    public ValidateDepartmentErrors getErrors() {
        return errors;
    }



    public ValidateDepartmentErrors validate(HttpServletRequest req){

        Department department = GetDepartment.getDepartmentFromReq(req);

        if (department.getTitle().isEmpty()){
            errors.setTitleError("Department title cant be empty!");
            isValid = false;
        } else if (department.getTitle().length() < MIN || department.getTitle().length() > MAX){
            errors.setTitleError("Length of department's title should be between " + MIN + " and " + MAX + " letters");
            isValid = false;
        }

        if (department.getDescription().isEmpty()){
            errors.setDescriptionError("Description of department cant be empty!");
            isValid = false;
        }

        if (department.getDisposition().isEmpty()){
            errors.setDispositionError("Disposition of department cant be empty!");
            isValid = false;
        }

        return errors;
    }

    public boolean isValid() {
        return isValid;
    }
}
