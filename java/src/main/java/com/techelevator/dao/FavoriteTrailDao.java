package com.techelevator.dao;

import com.techelevator.model.FavoriteTrail;

import java.util.List;

public interface FavoriteTrailDao {

    List<FavoriteTrail> getUsersFavoriteTrails(String username);

    void deleteTrail(int trailId, String username);

    FavoriteTrail addTrail(FavoriteTrail trail, int userId);

}
