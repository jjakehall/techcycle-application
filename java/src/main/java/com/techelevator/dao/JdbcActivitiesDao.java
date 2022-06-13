package com.techelevator.dao;

import com.techelevator.model.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcActivitiesDao implements ActivitiesDao
{
    JdbcTemplate jdbcTemplate;
    public JdbcActivitiesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Activity> getActivityByUser(String username)
    {
        List<Activity> activities = new ArrayList<>();
        String sql = "SELECT * FROM activities WHERE username = ? ORDER BY activity_date DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()) {
            activities.add(mapRowToActivity(results));
        }
        return activities;
    }

    @Override
    public Activity getActivityByDescription(String activityDescription)
    {
        String sql = "SELECT * FROM activities WHERE description ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, activityDescription);
        if(results.next()) {
            return mapRowToActivity(results);
        } else {
            throw new RuntimeException("This description was not found");
        }
    }

    @Override
    public Activity createActivity(Activity newActivity, String userName, int userId) {
        String sql = "INSERT INTO activities (user_id, username, activity_name, description, activity_date, distance_mi, elevation_ft, elapsed_time, ispublic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING activity_id;";
        int activityId = jdbcTemplate.queryForObject(sql
                , Integer.class
                , userId
                , userName
                , newActivity.getActivityName()
                , newActivity.getActivityDescription()
                , newActivity.getActivityDate()
                , newActivity.getActivityDistance()
                , newActivity.getActivityElevation()
                , newActivity.getElapsedTime()
                , newActivity.getActivityPublic());
        newActivity.setActivityId(activityId);
        return newActivity;
    }
    @Override
    public void deleteActivity(Long activityId)
    {
        String sql ="DELETE FROM activities WHERE activity_id = ?;";
        jdbcTemplate.update(sql, activityId);
    }
    @Override
    public Activity updateActivity(Activity updatedActivity, Long activityId)
    {
        String sql = "UPDATE activities SET activity_name = ?, description = ?, activity_date = ?, distance_mi = ?, elevation_ft = ?, elapsed_time = ?, ispublic = ? WHERE activity_id = ?;";
        jdbcTemplate.update(sql
                , updatedActivity.getActivityName()
                , updatedActivity.getActivityDescription()
                , updatedActivity.getActivityDate()
                , updatedActivity.getActivityDistance()
                , updatedActivity.getActivityElevation()
                , updatedActivity.getElapsedTime()
                , updatedActivity.getActivityPublic()
                , activityId);

        return updatedActivity;
    }

    @Override
    public List<Activity> getPublicActivities() {
        List<Activity> activities = new ArrayList<>();
        String sql = "SELECT * FROM activities WHERE isPublic = TRUE ORDER BY activity_date DESC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            activities.add(mapRowToActivity(results));
        }
        return activities;
    }


    private Activity mapRowToActivity(SqlRowSet rs)
    {
        Activity activities = new Activity();
        activities.setActivityId(rs.getInt("activity_id"));
        activities.setActivityName(rs.getString("activity_name"));
        activities.setUserId((rs.getInt("user_id")));
        activities.setUsername(rs.getString("username"));
        activities.setActivityDescription(rs.getString("description"));
        if(rs.getDate("activity_date") != null)
        {
            activities.setActivityDate(rs.getDate("activity_date").toLocalDate());
        }
        activities.setActivityDistance(rs.getDouble("distance_mi"));
        activities.setActivityElevation(rs.getInt("elevation_ft"));
        activities.setElapsedTime(rs.getDouble("elapsed_time"));
        activities.setActivityPublic(rs.getBoolean("isPublic"));

        return activities;
    }
}
