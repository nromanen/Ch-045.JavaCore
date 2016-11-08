package com.ariezz.dao;

import com.ariezz.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05.11.16.
 */
public class DepartmentDao extends AbstractDao <Department, Integer> {




    @Override
    public List<Department> getAll() {

        List <Department> list = new ArrayList<>();

        try {
            ResultSet rs = getStatement().executeQuery("SELECT * FROM department WHERE id <>  1");
            while (rs.next()){
                Department d = new Department();
                d.setDepId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setDisposition(rs.getString("disposition"));

                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Department getEntityById(Integer id) {

        Department d = new Department();

        try {

            PreparedStatement ps = getPrepareStatement("SELECT * FROM department WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                d.setDepId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setDisposition(rs.getString("disposition"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d;
    }

    @Override
    public Department update(Department entity) {

        PreparedStatement ps = getPrepareStatement("UPDATE department SET title = ?, description = ? , disposition = ? WHERE id = ?");
        try {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getDisposition());
            ps.setInt(4, entity.getDepId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getEntityById(entity.getDepId());
    }

    @Override
    public boolean delete(Integer id) {

        PreparedStatement ps = getPrepareStatement("DELETE FROM department WHERE id = ?");
        try {
            ps.setInt(1, id);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Department was not deleted!");

    }

    @Override
    public boolean create(Department entity) {

        PreparedStatement ps = getPrepareStatement("Insert into department (title, description, disposition) values (?, ?, ?)");
        try {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getDisposition());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public Department getEntityByName(String title) {

        Department d = new Department();

        try {

            PreparedStatement ps = getPrepareStatement("SELECT * FROM department WHERE title = ?");
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                d.setDepId(rs.getInt("id"));
                d.setTitle(rs.getString("title"));
                d.setDescription(rs.getString("description"));
                d.setDisposition(rs.getString("disposition"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }
}
