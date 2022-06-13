package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Trails;
import com.techelevator.services.GoogleMaps;
import com.techelevator.services.TrailAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
public class TrailAPIController
{
    @Autowired
    GoogleMaps googleMaps;

    @Autowired
    TrailAPI trailApiService;

    @RequestMapping(path = "/explore", method = RequestMethod.GET)
    public List<Trails> exploreTrails(@RequestParam String address) throws IOException, InterruptedException
    {
        return trailApiService.getTrails(googleMaps.getLatitudeLongitude(address));
    }
}
