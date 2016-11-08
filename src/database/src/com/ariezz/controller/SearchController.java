package com.ariezz.controller;

import com.ariezz.dao.DepartmentDao;
import com.ariezz.dao.EmployeeDao;
import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.util.DBConnection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 08.11.16.
 */
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection.getConnection();
        EmployeeDao employeeDao = new EmployeeDao();

        List<Employee> employeeList = employeeDao.getEntityByName(req.getParameter("search"));

        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> dList = departmentDao.getAll();

        req.setAttribute("employeeList", employeeList);
        req.setAttribute("data", dList);
        req.setAttribute("search", req.getParameter("search"));
        req.getRequestDispatcher("/WEB-INF/jsps/search.jsp").forward(req, resp);

    }
}
