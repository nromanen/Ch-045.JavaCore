package com.ariezz.controller;

import com.ariezz.model.Department;
import com.ariezz.model.Employee;
import com.ariezz.util.GetDepartment;
import com.ariezz.validator.DepartmentValidator;

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
 * Created by Admin on 10.11.16.
 */

@WebServlet("/departmentUpdate")
public class DepartmentUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pk = Integer.parseInt(req.getParameter("pk"));

        Department dep = departmentDao.getEntityById(pk);

        List<Department> dList = departmentDao.getAll();
        List<Employee> employeeList = employeeDao.getAll();
        req.setAttribute("data", dList);
        req.setAttribute("dep", dep);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("link", "departmentUpdate");
        req.setAttribute("message", "!!! Edit");
        req.getRequestDispatcher("/WEB-INF/jsps/departmentUpdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DepartmentValidator validator = new DepartmentValidator();

        int pk = Integer.parseInt(req.getParameter("pk"));

        Department department = GetDepartment.getDepartmentFromReq(req);
        department.setDepId(pk);

        validator.validate(req);


        List<Employee> employeeListByDep = employeeDao.getAllByDepartment(pk);

        if(validator.isValid()){
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

            department = departmentDao.update(department);

            List<Employee> employeeList = employeeDao.getAllByDepartment(pk);
            List<Department> dList = departmentDao.getAll();
            req.setAttribute("dep", department);
            req.setAttribute("employeeList", employeeList);
            req.setAttribute("data", dList);
            req.getRequestDispatcher("/WEB-INF/jsps/department.jsp").forward(req, resp);
        }

        List<Department> dList = departmentDao.getAll();
        List<Employee> employeeList = employeeDao.getAll();
        req.setAttribute("data", dList);
        req.setAttribute("dep", department);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("link", "departmentUpdate");
        req.setAttribute("errors", validator.getErrors());
        req.setAttribute("message", "!!! Edit");
        req.getRequestDispatcher("/WEB-INF/jsps/departmentUpdate.jsp").forward(req, resp);



    }

}
