package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Segments;
import com.techelevator.services.GoogleMaps;
import com.techelevator.services.Strava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class StravaController {

    @Autowired
    GoogleMaps googleMaps;

    @Autowired
    Strava stravaService;

    private String token = "";

    @RequestMapping(path = "/authorize", method = RequestMethod.POST)
    public void getToken(@RequestParam String authorizationCode) throws IOException
    {
        token = stravaService.getToken(authorizationCode);
        System.out.println(token);
    }

    @RequestMapping(path = "/segments", method = RequestMethod.GET)

    public List<Segments> exploreSegments(@RequestParam String address) throws JsonProcessingException {

        String latLon = googleMaps.getLatitudeLongitude(address);
        String bounds = googleMaps.getBounds(latLon);
        System.out.println(bounds);
        return stravaService.getSegments(token, bounds);
    }
   /* @RequestMapping(path = "/activities", method = RequestMethod.POST)
    public void uploadActivity(@RequestParam String name , String type, Date start_date_local, Integer elapsed_time, String description, Float distance)
    {
        //stravaService.manualUpload(token, name, type, start_date_local, elapsed_time, description, distance);

    }*/


}