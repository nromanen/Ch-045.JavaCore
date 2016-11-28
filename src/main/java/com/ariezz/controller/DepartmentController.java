package com.ariezz.controller;


import com.ariezz.model.Department;
import com.ariezz.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.ariezz.dao.GetDao.departmentDao;
import static com.ariezz.dao.GetDao.employeeDao;

/**
 * Created by Admin on 06.11.16.
 */

@WebServlet("/department")
public class DepartmentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            int pk = Integer.parseInt(req.getParameter("pk"));

            Department department = departmentDao.getEntityById(pk);
            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);
            List<Department> dList = departmentDao.getAll();
            req.setAttribute("dep", department);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/department.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pk = Integer.parseInt(req.getParameter("pk"));
        List<Employee> employeeList = employeeDao.getAllByDepartment(pk);

        for (Employee e : employeeList) {
            e.setDepartment(departmentDao.getEntityById(1));
            employeeDao.update(e);
        }

        departmentDao.delete(pk);
        List<Department> dList = departmentDao.getAll();

        req.setAttribute("data", dList);
        req.setAttribute("message", "Department was deleted!");
        req.getRequestDispatcher("/WEB-INF/jsps/main.jsp").forward(req, resp);

    }

}
