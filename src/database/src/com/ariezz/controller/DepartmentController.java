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
public class DepartmentController extends HttpServlet {

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
            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);

            for (Employee e: employeeList) {
                employeeDao.delete(e.getEmId());
            }

            departmentDao.delete(pk);
            List<Department> dList = departmentDao.getAll();

            req.setAttribute("data", dList);
            req.setAttribute("message", "Department was deleted!");
            req.getRequestDispatcher("/WEB-INF/jsps/main.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("get")) {

            int pk = Integer.parseInt(req.getParameter("pk"));

            Department department = departmentDao.getEntityById(pk);
            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);
            List<Department> dList = departmentDao.getAll();
            req.setAttribute("dep", department);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/dep.jsp").forward(req, resp);
        } else if (action.equalsIgnoreCase("new")){

            List<Department> dList = departmentDao.getAll();
            List<Employee> employeeList = employeeDao.getAll();
            req.setAttribute("data", dList);
            req.setAttribute("employeeList", employeeList);
            req.getRequestDispatcher("/WEB-INF/jsps/newDep.jsp").forward(req, resp);

        } else if (action.equalsIgnoreCase("edit")){
            int pk = Integer.parseInt(req.getParameter("pk"));

            Department dep = departmentDao.getEntityById(pk);

            List<Department> dList = departmentDao.getAll();
            List<Employee> employeeList = employeeDao.getAll();
            req.setAttribute("data", dList);
            req.setAttribute("dep", dep);
            req.setAttribute("employeeList", employeeList);
            req.getRequestDispatcher("/WEB-INF/jsps/depUp.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initial();

        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("edit")) {

            int pk = Integer.parseInt(req.getParameter("pk"));

            List<Employee> employeeListByDep = employeeDao.getAllByDepartment(pk);

            try {
                if (employeeListByDep != null) {
                    for (Employee e : employeeListByDep) {
                        e.setDepartment(departmentDao.getEntityById(1));
                        employeeDao.update(e);
                    }
                }
            } catch (NullPointerException exc){}

            if (req.getParameterValues("emp") != null) {
                String[] employeeId = req.getParameterValues("emp");

                for (String s: employeeId) {
                    Employee e = employeeDao.getEntityById(Integer.parseInt(s));
                    e.setDepartment(departmentDao.getEntityById(pk));
                    employeeDao.update(e);
                }
            }


            Department department = new Department();
            department.setTitle(req.getParameter("title"));
            department.setDisposition(req.getParameter("disposition"));
            department.setDescription(req.getParameter("description"));
            department.setDepId(pk);

            department = departmentDao.update(department);

            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);
            List<Department> dList = departmentDao.getAll();
            req.setAttribute("dep", department);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/dep.jsp").forward(req, resp);

        }else if (action.equalsIgnoreCase("new")){

            Department department = new Department();
            department.setTitle(req.getParameter("title"));
            department.setDisposition(req.getParameter("disposition"));
            department.setDescription(req.getParameter("description"));

            departmentDao.create(department);

            department = departmentDao.getEntityByName(req.getParameter("title"));

            int pk = department.getDepId();

            if (req.getParameterValues("emp") != null) {
                String[] employeeId = req.getParameterValues("emp");

                for (String s: employeeId) {
                    Employee e = employeeDao.getEntityById(Integer.parseInt(s));
                    e.setDepartment(departmentDao.getEntityById(pk));
                    employeeDao.update(e);
                }
            }

            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);
            List<Department> dList = departmentDao.getAll();
            req.setAttribute("dep", department);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/dep.jsp").forward(req, resp);

        }
    }

}
