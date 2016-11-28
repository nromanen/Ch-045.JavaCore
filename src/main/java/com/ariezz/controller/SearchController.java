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

@WebServlet("/search")
public class SearchController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employeeList = employeeDao.getEntityByName(req.getParameter("search"));
        List<Department> dList = departmentDao.getAll();

        req.setAttribute("isResult", employeeList.size() != 0? 1: 0);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("data", dList);
        req.setAttribute("message", "!!Result of search by " + "\"" + req.getParameter("search") + "\"");
        req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);

    }
}
