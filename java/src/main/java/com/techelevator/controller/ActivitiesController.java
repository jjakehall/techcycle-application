package com.techelevator.controller;

import com.techelevator.dao.ActivitiesDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class ActivitiesController
{
    @Autowired
    private ActivitiesDao activitiesDao;

    @Autowired
    private UserDao userDao;
    public ActivitiesController(ActivitiesDao activitiesDao) {
        this.activitiesDao = activitiesDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/activity", method = RequestMethod.POST)
    public Activity createActivity(@RequestBody Activity activity, Principal principal)
    {
        int userId = userDao.findIdByUsername(principal.getName());
        return activitiesDao.createActivity(activity, principal.getName(), userId);
    }

    @RequestMapping(path ="activity/{activityId}", method = RequestMethod.PUT)
    public Activity updateActivity(@RequestBody Activity activity, @PathVariable Long activityId) {
        return activitiesDao.updateActivity(activity, activityId);
    }

    @RequestMapping(path ="activity/{activityId}", method = RequestMethod.DELETE)
    public void deleteActivity(@PathVariable Long activityId) {
        activitiesDao.deleteActivity(activityId);
    }

    @RequestMapping(path = "/activity/user", method = RequestMethod.GET)
    public List<Activity> getActivityByUser(Principal principal) {
        String username = principal.getName();
        return activitiesDao.getActivityByUser(username);
    }

    @RequestMapping(path = "activity/public", method = RequestMethod.GET)
    public List<Activity> getPublicActivities() {
        return activitiesDao.getPublicActivities();
    }
}
