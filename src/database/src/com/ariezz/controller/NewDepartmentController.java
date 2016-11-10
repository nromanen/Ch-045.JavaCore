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


@WebServlet(name = "NewDepartmentController", urlPatterns = {"/newDepartment"})
public class NewDepartmentController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Department> dList = departmentDao.getAll();
        List<Employee> employeeList = employeeDao.getAll();
        req.setAttribute("data", dList);
        req.setAttribute("employeeList", employeeList);
        req.setAttribute("message", "Create new Department");
        req.setAttribute("link", "newDepartment");
        req.getRequestDispatcher("/WEB-INF/jsps/departmentUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



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
            req.getRequestDispatcher("/WEB-INF/jsps/department.jsp").forward(req, resp);

        }

}
