package com.techelevator.dao;

import com.techelevator.model.FavoriteTrail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoriteTrailsDao implements FavoriteTrailDao {

    JdbcTemplate jdbcTemplate;

    public JdbcFavoriteTrailsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<FavoriteTrail> getUsersFavoriteTrails(String username) {
        List<FavoriteTrail> trails = new ArrayList<>();
        String sql = "SELECT * FROM favorite_trails WHERE username = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()) {
            trails.add(mapRowToTrail(results));
        }
        return trails;
    }

    @Override
    public void deleteTrail(int trailId, String username) {
        String sql = "DELETE FROM favorite_trails WHERE trail_id = ? AND username = ?";
        jdbcTemplate.update(sql, trailId, username);
    }

    @Override
    public FavoriteTrail addTrail(FavoriteTrail trail, int userId) {
        String sql = "INSERT INTO favorite_trails (user_id, trail_name, trail_distance, trail_description, trail_difficulty, trail_grade) VALUES (?, ?, ?, ?, ?, ?) RETURNING trail_id;";
        int trailId = jdbcTemplate.queryForObject(
                sql
                , Integer.class
                , userId
                , trail.getName()
                , trail.getDistance()
                , trail.getDescription()
                , trail.getDifficulty()
                , trail.getGrade());
        trail.setTrailId(trailId);
        return trail;
    }

    private FavoriteTrail mapRowToTrail(SqlRowSet results) {
        FavoriteTrail trail = new FavoriteTrail();
        trail.setTrailId(results.getInt("trail_id"));
        trail.setName(results.getString("trail_name"));
        trail.setDistance(results.getDouble("trail_distance"));
        trail.setDescription(results.getString("trail_description"));
        trail.setDifficulty(results.getString("trail_difficulty"));
        trail.setGrade(results.getString("trail_grade"));
        return trail;
    }

}
