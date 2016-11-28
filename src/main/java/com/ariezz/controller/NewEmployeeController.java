package com.ariezz.controller;

import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.model.Position;
import com.ariezz.util.GetEmployee;
import com.ariezz.validator.EmployeeValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.ariezz.dao.GetDao.*;

/**
 * Created by Admin on 09.11.16.
 */

@WebServlet("/newEmployee")
public class NewEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Department> dList = departmentDao.getAll();
        List<Position> positions = positionDao.getAll();

        req.setAttribute("data", dList);
        req.setAttribute("positions", positions);
        req.setAttribute("message", "!!Create new Employee");
        req.setAttribute("link", "newEmployee");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       EmployeeValidator validator = new EmployeeValidator();

        System.out.println(validator.validate(req));


        Employee employee = GetEmployee.getEmployeeFromReq(req);
        employee.setDepartment(departmentDao.getEntityByName(req.getParameter("department")));
        employee.setPosition(Position.valueOf(req.getParameter("position")));

        List<Department> dList = departmentDao.getAll();


        if(validator.isValid()) {
            employeeDao.create(employee);
            List<Employee> employeeList = employeeDao.getAll();

            req.setAttribute("isResult", employeeList.size() != 0? 1: 0);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("message", "All Employee");
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);
        }

        List<Position> positions = positionDao.getAll();

        req.setAttribute("employee", employee);
        req.setAttribute("errors", validator.getErrors());
        req.setAttribute("data", dList);
        req.setAttribute("positions", positions);
        req.setAttribute("message", "Create new Employee");
        req.setAttribute("link", "newEmployee");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);

    }
}
