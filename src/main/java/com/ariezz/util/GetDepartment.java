package com.ariezz.util;

import com.ariezz.model.Department;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 13.11.16.
 */
public class GetDepartment {

    public static Department getDepartmentFromReq(HttpServletRequest req) {

        Department department = new Department();

        try {
            department.setTitle(req.getParameter("title"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            department.setDescription(req.getParameter("description"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            department.setDisposition(req.getParameter("disposition"));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return department;
    }
}
