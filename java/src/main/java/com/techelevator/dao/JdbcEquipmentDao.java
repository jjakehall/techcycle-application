package com.techelevator.dao;

import com.techelevator.model.Equipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEquipmentDao implements EquipmentDao
{
    private JdbcTemplate jdbcTemplate;

    public JdbcEquipmentDao(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    };
    @Override
    public List<Equipment> getEquipmentByUser(int userId)
    {
        List<Equipment> equipment = new ArrayList<>();
        String sql = "SELECT * FROM equipment WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            equipment.add(mapRowToEquipment(results));
        }
        return equipment;
    }

    @Override
    public Equipment createEquipment(Equipment newEquipment, int userId)
    {
       String sql = "INSERT INTO equipment (user_id, bike_model, bike_weight, bike_brand, nickname) VALUES (?, ?, ?, ?, ?) RETURNING equipment_id;";
       int equipmentId = jdbcTemplate.queryForObject(sql, Integer.class, userId, newEquipment.getBikeModel(), newEquipment.getBikeWeight(), newEquipment.getBikeBrand(), newEquipment.getNickname());
       newEquipment.setEquipmentId(equipmentId);
       return newEquipment;
    }

    @Override
    public Equipment updateEquipment(Equipment updatedEquipment, int equipmentId)
    {
        String sql = "UPDATE equipment SET bike_brand = ?, nickname = ?, bikebike_model = ?, bike_weight = ? WHERE equipment_id = ?;";
        jdbcTemplate.update(sql
                            , updatedEquipment.getBikeBrand()
                            , updatedEquipment.getNickname()
                            , updatedEquipment.getBikeModel()
                            , updatedEquipment.getBikeWeight()
                            , equipmentId);
        return updatedEquipment;
    }

    @Override
    public void deleteEquipment(int equipmentId)
    {
        String sql = "DELETE FROM equipment WHERE equipment_id = ?;";
        jdbcTemplate.update(sql, equipmentId);
    }

    private Equipment mapRowToEquipment (SqlRowSet rs)
    {
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(rs.getInt("equipment_id"));
        equipment.setUserId(rs.getInt("user_id"));
        equipment.setBikeModel(rs.getString("bike_model"));
        equipment.setBikeWeight(rs.getInt("bike_weight"));
        equipment.setBikeBrand(rs.getString("bike_brand"));
        equipment.setNickname(rs.getString("nickname"));
        return equipment;
    }
}
