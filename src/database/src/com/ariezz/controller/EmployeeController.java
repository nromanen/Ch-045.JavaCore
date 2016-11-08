package com.ariezz.controller;

import com.ariezz.dao.DepartmentDao;
import com.ariezz.dao.EmployeeDao;
import com.ariezz.dao.PositionDao;
import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.model.Position;
import com.ariezz.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 06.11.16.
 */
public class EmployeeController extends HttpServlet {


    DepartmentDao departmentDao;
    EmployeeDao employeeDao;
    PositionDao positionDao;

    private void initial(){
        DBConnection.getConnection();
        if (this.departmentDao == null) {
            this.departmentDao = new DepartmentDao();
        }
        if(this.employeeDao == null) {
            this.employeeDao = new EmployeeDao();
        }
        if (this.positionDao == null){
            this.positionDao = new PositionDao();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initial();

        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int pk = Integer.parseInt(req.getParameter("pk"));
            employeeDao.delete(pk);
            List<Department> dList = departmentDao.getAll();

            req.setAttribute("data", dList);
            req.setAttribute("message", "Employee was deleted!");
            req.getRequestDispatcher("/WEB-INF/jsps/main.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("get")){
            int pk = Integer.parseInt(req.getParameter("pk"));
            Employee employee = employeeDao.getEntityById(pk);
            List<Department> dList = departmentDao.getAll();

            req.setAttribute("employee", employee);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/employee.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("edit")){
            int pk = Integer.parseInt(req.getParameter("pk"));

            Employee employee = employeeDao.getEntityById(pk);

            List<Department> dList = departmentDao.getAll();
            List<Position> positions = new PositionDao().getAll();

            req.setAttribute("employee", employee);
            req.setAttribute("data", dList);
            req.setAttribute("positions", positions);
            req.getRequestDispatcher("/WEB-INF/jsps/employeeUp.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("getAll")){
            List<Employee> employeeList = employeeDao.getAll();

            List<Department> dList = departmentDao.getAll();

            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("new")){

            List<Department> dList = departmentDao.getAll();
            List<Position> positions = positionDao.getAll();

            req.setAttribute("data", dList);
            req.setAttribute("positions", positions);
            req.getRequestDispatcher("/WEB-INF/jsps/newEmployee.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initial();

        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("update")) {

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

        }else if (action.equalsIgnoreCase("new")){
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


            employee.setDepartment(new DepartmentDao().getEntityByName(req.getParameter("department")));
            employee.setPosition(Position.valueOf(req.getParameter("position")));

            employeeDao.create(employee);

            List<Department> dList = departmentDao.getAll();

            List<Employee> employeeList = employeeDao.getAll();
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/allEmployees.jsp").forward(req, resp);
        }
    }
}
