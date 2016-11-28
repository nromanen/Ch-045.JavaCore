package com.ariezz.dao;

import com.ariezz.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06.11.16.
 */
public class PositionDao extends AbstractDao<Position, Integer>{


    @Override
    public List<Position> getAll() {
        List<Position> positions = new ArrayList<>();

        try {
            ResultSet rs = getStatement().executeQuery("SELECT * FROM position");

            while (rs.next()){
                positions.add(Position.valueOf(rs.getString("name")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return positions;

    }

    @Override
    public Position getEntityById(Integer id) {

        return getAll().get(id);
    }

    @Override
    public Position update(Position entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Position entity) {
        throw new UnsupportedOperationException();
    }
}
