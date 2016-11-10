package com.ariezz.controller;

import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.model.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.ariezz.dao.GetDao.departmentDao;
import static com.ariezz.dao.GetDao.employeeDao;
import static com.ariezz.dao.GetDao.positionDao;

@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/employeeUpdate"})
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
        req.setAttribute("message", "Edit profile of");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setEmail(req.getParameter("email"));
        employee.setCharacteristic(req.getParameter("char"));
        employee.setSSN(Integer.parseInt(req.getParameter("ssn")));
        employee.setRate(Integer.parseInt(req.getParameter("rate")));

        try {
            Date bDay = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bDay"));
            employee.setbDay(bDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        employee.setEmId(Integer.parseInt(req.getParameter("pk")));
        employee.setDepartment(departmentDao.getEntityByName(req.getParameter("department")));
        employee.setPosition(Position.valueOf(req.getParameter("position")));

        employee = employeeDao.update(employee);

        List<Department> dList = departmentDao.getAll();

        req.setAttribute("employee", employee);
        req.setAttribute("data", dList);
        req.getRequestDispatcher("/WEB-INF/jsps/employee.jsp").forward(req, resp);

    }
}
