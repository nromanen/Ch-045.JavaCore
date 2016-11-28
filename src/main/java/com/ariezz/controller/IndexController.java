package com.ariezz.controller;

import com.ariezz.dao.DepartmentDao;
import com.ariezz.model.Department;
import com.ariezz.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection.getConnection();

        DepartmentDao departmentDao = new DepartmentDao();

        List<Department> dList = departmentDao.getAll();

        req.setAttribute("data", dList);

        req.getRequestDispatcher("/WEB-INF/jsps/main.jsp").forward(req, resp);
    }
}
