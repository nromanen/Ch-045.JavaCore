package com.ariezz.controller;

import com.ariezz.model.Department;
import com.ariezz.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import static com.ariezz.dao.GetDao.departmentDao;
import static com.ariezz.dao.GetDao.employeeDao;

@WebServlet(name = "DepartmentUpdateController", urlPatterns = {"/departmentUpdate"})
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
        req.setAttribute("message", "Edit");
        req.getRequestDispatcher("/WEB-INF/jsps/departmentUpdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        req.getRequestDispatcher("/WEB-INF/jsps/department.jsp").forward(req, resp);

    }

}
