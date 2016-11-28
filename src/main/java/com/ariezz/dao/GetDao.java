package com.ariezz.dao;

import com.ariezz.util.DBConnection;

/**
 * Created by Admin on 09.11.16.
 */
public class GetDao {

    static {
        DBConnection.getConnection();
    }
    public static DepartmentDao departmentDao = new DepartmentDao();
    public static EmployeeDao employeeDao = new EmployeeDao();
    public static PositionDao positionDao = new PositionDao();

}
