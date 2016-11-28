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

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String action = req.getParameter("action");
            if (action.equalsIgnoreCase("getAll")){
                List<Employee> employeeList = employeeDao.getAll();

                List<Department> dList = departmentDao.getAll();

                req.setAttribute("isResult", employeeList.size() != 0? 1: 0);
                req.setAttribute("employeeList", employeeList);
                req.setAttribute("data", dList);
                req.setAttribute("message", "All Employee!!!");
                req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);

            }
        } catch (NullPointerException e){
            System.out.println(e);
        }


        int pk = Integer.parseInt(req.getParameter("pk"));
        Employee employee = employeeDao.getEntityById(pk);
        List<Department> dList = departmentDao.getAll();

        req.setAttribute("employee", employee);
        req.setAttribute("data", dList);
        req.getRequestDispatcher("/WEB-INF/jsps/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pk = Integer.parseInt(req.getParameter("pk"));
        employeeDao.delete(pk);
        List<Department> dList = departmentDao.getAll();

        req.setAttribute("data", dList);
        req.setAttribute("message", "Employee was deleted!");
        req.getRequestDispatcher("/WEB-INF/jsps/main.jsp").forward(req, resp);
    }

}
