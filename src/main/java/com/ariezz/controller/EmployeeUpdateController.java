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

@WebServlet("/employeeUpdate")
public class EmployeeUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pk = Integer.parseInt(req.getParameter("pk"));

        Employee employee = employeeDao.getEntityById(pk);

        List<Department> dList = departmentDao.getAll();
        List<Position> positions = positionDao.getAll();

        req.setAttribute("employee", employee);
        req.setAttribute("data", dList);
        req.setAttribute("positions", positions);
        req.setAttribute("link", "employeeUpdate");
        req.setAttribute("message", "!!Edit profile of ");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeValidator validator = new EmployeeValidator();

        validator.validate(req);

        Employee employee = GetEmployee.getEmployeeFromReq(req);

        employee.setDepartment(departmentDao.getEntityByName(req.getParameter("department")));
        employee.setPosition(Position.valueOf(req.getParameter("position")));
        employee.setEmId(Integer.parseInt(req.getParameter("pk")));

        List<Department> dList = departmentDao.getAll();


        if(validator.isValid()) {
            employee = employeeDao.update(employee);

            req.setAttribute("employee", employee);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/employee.jsp").forward(req, resp);
        }

        List<Position> positions = positionDao.getAll();

        req.setAttribute("employee", employee);
        req.setAttribute("errors", validator.getErrors());
        req.setAttribute("data", dList);
        req.setAttribute("positions", positions);
        req.setAttribute("message", "Create new Employee");
        req.setAttribute("link", "employeeUpdate");
        req.setAttribute("message", "Edit profile of ");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);


    }
}
