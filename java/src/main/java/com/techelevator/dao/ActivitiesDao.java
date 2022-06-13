package com.techelevator.dao;

import com.techelevator.model.Activity;

import java.util.List;

public interface ActivitiesDao
{
    List<Activity> getActivityByUser (String userId);
    Activity getActivityByDescription (String activityDescription);
    //Activities getActivityByDate (Date activityDate);
    Activity createActivity(Activity activity, String userName, int userId);
    List<Activity> getPublicActivities ();
    Activity updateActivity (Activity updatedActivity, Long activityId);
    void deleteActivity(Long activityId);

}
