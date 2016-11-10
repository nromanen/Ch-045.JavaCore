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

@WebServlet(name = "NewEmployeeController", urlPatterns = {"/newEmployee"})
public class NewEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Department> dList = departmentDao.getAll();
        List<Position> positions = positionDao.getAll();

        req.setAttribute("data", dList);
        req.setAttribute("positions", positions);
        req.setAttribute("message", "Create new Employee");
        req.setAttribute("link", "newEmployee");
        req.getRequestDispatcher("/WEB-INF/jsps/employeeUpdate.jsp").forward(req, resp);

    }

    //delete employee from DB
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

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


        employee.setDepartment(departmentDao.getEntityByName(req.getParameter("department")));
        employee.setPosition(Position.valueOf(req.getParameter("position")));

        employeeDao.create(employee);

        List<Department> dList = departmentDao.getAll();

        List<Employee> employeeList = employeeDao.getAll();
        req.setAttribute("isResult", employeeList.size() != 0? 1: 0);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("message", "All Employee");
        req.setAttribute("data", dList);
        req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);
    }
}
