package com.ariezz;

import com.ariezz.dao.DepartmentDao;
import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.util.DBConnection;

import java.util.List;

/**
 * Created by Admin on 05.11.16.
 */
public class Main {
    public static void main(String[] args) {
        DBConnection.getConnection();

        DepartmentDao departmentDao = new DepartmentDao();

        List<Department> dList = departmentDao.getAll();

        for (Department d : dList) {
            System.out.println(d);
        }
    }
}
