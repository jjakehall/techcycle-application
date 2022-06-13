package com.techelevator.controller;

import com.techelevator.dao.FavoriteTrailDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FavoriteTrail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class FavoriteTrailController {

    @Autowired
    private FavoriteTrailDao favoriteTrailDao;

    @Autowired
    private UserDao userDao;

    public FavoriteTrailController(FavoriteTrailDao favoriteTrailDao) {
        this.favoriteTrailDao = favoriteTrailDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/favortietrail", method = RequestMethod.POST)
    public FavoriteTrail addTrail(@RequestBody FavoriteTrail trail, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return favoriteTrailDao.addTrail(trail, userId);
    }

}
