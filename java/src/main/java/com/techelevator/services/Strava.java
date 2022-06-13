package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Activity;
import com.techelevator.model.Segments;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Strava {

    @Value("${strava.api.secret}")
    String apiSecret;

    @Value("${strava.api.clientId}")
    String apiClientId;

    @Value("${strava.token.url}")
    String url;

    @Value("${strava.url}")
    String stravaApiUrl;



    public String getToken(String authorizationCode) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        String clientId = "client_id=" + this.apiClientId;
        String clientSecret= "&client_secret=" + this.apiSecret;
        String code = "&code=" + authorizationCode;
        String grantType = "&grant_type=authorization_code";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "";
        HttpEntity<String> request = new HttpEntity<>(body, httpHeaders);

        String url = this.url + clientId + clientSecret + code + grantType;
        System.out.println(url);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        String token = jsonNode.path("access_token").asText();
        System.out.println(token);

        return token;
    }

    public List<Segments> getSegments(String token, String bounds) throws JsonProcessingException
    {

        RestTemplate restTemplate = new RestTemplate();

        String segment = "segments/explore?=&bounds=" + bounds;
        String activity = "&activity_type=riding";

        String segmentUrl = this.stravaApiUrl + segment + activity;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(segmentUrl, HttpMethod.GET, httpEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        List<Segments> listOfSegments = new ArrayList<>();

        for(int i = 0; i < 10; i++)
        {
            String name = jsonNode.path("segments").path(i).path("name").asText();
            String segmentId = jsonNode.path("segments").path(i).path("id").asText();
            String elevationGain = jsonNode.path("segments").path(i).path("elev_difference").asText();
            String distance = jsonNode.path("segments").path(i).path("distance").asText();
            String grade = jsonNode.path("segments").path(i).path("avg_grade").asText();

            Segments segments = new Segments(name, segmentId, elevationGain, distance, grade);
            listOfSegments.add(segments);
        }

        return listOfSegments;
    }

   /* public Activity manualUpload(String token, String name, String activityType, String activityDescription, Date activityDate, int elapsedTime, float activityDistance, int activityElevation) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String activityName = "?name=" + name;
        String type = "&type=" + activityType;
        String startDateLocal = "&start_date_local=" + activityDate;
        String duration = "&elapsed_time=" + elapsedTime;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + token);

        String body = "";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        String uploadUrl = stravaApiUrl + activityName + type + startDateLocal + duration;
        ResponseEntity<String> response = restTemplate.exchange(uploadUrl, HttpMethod.POST, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        Activity newActivity = new Activity();
        activityName = jsonNode.path("name").asText();
        activityDescription = jsonNode.path("description").asText();
        //activityDate = jsonNode.path("start_date_local");
        elapsedTime = jsonNode.path("elapsed_time").asInt();
        activityDistance = jsonNode.path("distance").floatValue();
        activityElevation = jsonNode.path("total_elevation_gain").


        return newActivity;
    }*/


}