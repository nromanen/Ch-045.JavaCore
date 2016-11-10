package com.ariezz.dao;


import com.ariezz.model.Employee;
import com.ariezz.model.Position;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.11.16.
 */
public class EmployeeDao extends AbstractDao<Employee, Integer> {

    @Override
    public List<Employee> getAll() {

        List<Employee> list = new ArrayList<>();

        DepartmentDao departmentDao = new DepartmentDao();
        PositionDao positionDao = new PositionDao();

        try {
            ResultSet rs =  getStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPosition(positionDao.getEntityById(rs.getInt("position")-1));
                employee.setDepartment(departmentDao.getEntityById(rs.getInt("department")));
                employee.setEmail(rs.getString("email"));
                employee.setbDay(rs.getDate("bDay"));
                employee.setSSN(rs.getInt("ssn"));
                employee.setCharacteristic(rs.getString("characteristic"));
                employee.setRate(rs.getInt("rate"));

                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;


    }

    public List<Employee> getAllByDepartment(int pk){
        List<Employee> list = new ArrayList<>();

        try {

            ResultSet rs = getStatement().executeQuery("SELECT * FROM position");

            List<Position> positions = new ArrayList<>();

            while (rs.next()){
                positions.add(Position.valueOf(rs.getString("name")));
            }

            PreparedStatement ps = getPrepareStatement("SELECT * FROM employee WHERE department = ?");
            ps.setInt(1, pk);

            rs = ps.executeQuery();
            DepartmentDao departmentDao = new DepartmentDao();
            PositionDao positionDao = new PositionDao();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPosition(positionDao.getEntityById(rs.getInt("position")-1));
                employee.setDepartment(departmentDao.getEntityById(rs.getInt("department")));
                employee.setEmail(rs.getString("email"));
                employee.setbDay(rs.getDate("bDay"));
                employee.setSSN(rs.getInt("ssn"));
                employee.setCharacteristic(rs.getString("characteristic"));
                employee.setRate(rs.getInt("rate"));

                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public Employee getEntityById(Integer id) {

        Employee employee = new Employee();
        try {

            PreparedStatement ps = getPrepareStatement("SELECT * FROM employee WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            DepartmentDao departmentDao = new DepartmentDao();
            PositionDao positionDao = new PositionDao();

            while (rs.next()){
                employee.setEmId(id);
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPosition(positionDao.getEntityById(rs.getInt("position")-1));
                employee.setDepartment(departmentDao.getEntityById(rs.getInt("department")));
                employee.setEmail(rs.getString("email"));
                employee.setbDay(rs.getDate("bDay"));
                employee.setSSN(rs.getInt("ssn"));
                employee.setCharacteristic(rs.getString("characteristic"));
                employee.setRate(rs.getInt("rate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public Employee update(Employee entity) {


        PreparedStatement ps = getPrepareStatement("UPDATE employee SET firstName = ?, lastName = ?, position = ?, department =?, ssn = ?, email = ?, bDay = ?, characteristic = ?, rate = ? where id = ?");
        try {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getPosition().ordinal()+1);
            ps.setInt(4, entity.getDepartment().getDepId());
            ps.setInt(5, entity.getSSN());
            ps.setString(6, entity.getEmail());

            java.sql.Date sqlDate = new java.sql.Date(entity.getbDay().getTime());
            ps.setDate(7, sqlDate);
            ps.setString(8, entity.getCharacteristic());
            ps.setInt(9, entity.getRate());
            ps.setInt(10, entity.getEmId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getEntityById(entity.getEmId());


    }

    @Override
    public boolean delete(Integer id) {

        PreparedStatement ps = getPrepareStatement("DELETE FROM employee WHERE id = ?");
        try {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Employee was not deleted!");

    }

    @Override
    public boolean create(Employee entity) {

        PreparedStatement ps = getPrepareStatement("Insert into employee (firstName, lastName, position, department, ssn, email, bDay, characteristic, rate) values (?, ?,?, ?, ?, ?, ?, ?, ?)");
        try {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getPosition().ordinal()+1);
            ps.setInt(4, entity.getDepartment().getDepId());
            ps.setInt(5, entity.getSSN());
            ps.setString(6, entity.getEmail());

            java.sql.Date sqlDate = new java.sql.Date(entity.getbDay().getTime());
            ps.setDate(7, sqlDate);
            ps.setString(8, entity.getCharacteristic());
            ps.setInt(9, entity.getRate());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;


    }

    public List<Employee> getEntityByName(String name){

        name = "%" + name + "%";

        List<Employee> employeeList = new ArrayList<>();
        try {

            PreparedStatement ps = getPrepareStatement("SELECT * FROM employee WHERE firstName LIKE ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            DepartmentDao departmentDao = new DepartmentDao();
            PositionDao positionDao = new PositionDao();

            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPosition(positionDao.getEntityById(rs.getInt("position")-1));
                employee.setDepartment(departmentDao.getEntityById(rs.getInt("department")));
                employee.setEmail(rs.getString("email"));
                employee.setbDay(rs.getDate("bDay"));
                employee.setSSN(rs.getInt("ssn"));
                employee.setCharacteristic(rs.getString("characteristic"));
                employee.setRate(rs.getInt("rate"));

                if (!employeeList.contains(employee)){
                    employeeList.add(employee);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            PreparedStatement ps = getPrepareStatement("SELECT * FROM employee WHERE lastName LIKE ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            DepartmentDao departmentDao = new DepartmentDao();
            PositionDao positionDao = new PositionDao();

            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPosition(positionDao.getEntityById(rs.getInt("position")-1));
                employee.setDepartment(departmentDao.getEntityById(rs.getInt("department")));
                employee.setEmail(rs.getString("email"));
                employee.setbDay(rs.getDate("bDay"));
                employee.setSSN(rs.getInt("ssn"));
                employee.setCharacteristic(rs.getString("characteristic"));
                employee.setRate(rs.getInt("rate"));

                if (!isInResult(employeeList, employee.getEmId())){
                    employeeList.add(employee);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    private boolean isInResult(List<Employee> employees, int id){

        for (Employee employee: employees) {
            if(employee.getEmId() == id){
                return true;
            }
        }

        return false;
    }

}
