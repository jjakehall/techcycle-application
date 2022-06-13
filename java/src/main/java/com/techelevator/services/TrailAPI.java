package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Trails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
@Component
public class TrailAPI
{
    @Value("https://trailapi-trailapi.p.rapidapi.com/trails/explore/?")
    String trailApiURl;

    public List<Trails> getTrails(String latitudeLongitude) throws IOException, InterruptedException
    {

        String[] latLon = latitudeLongitude.split("&");


        RestTemplate restTemplate = new RestTemplate();

        String trailLatitude = "lat=" + latLon[0];
        String trailLongitude = "&lon=" + latLon[1];
        String numberOfResults = "&per_page=10";

        String trailUrl = this.trailApiURl + trailLatitude + trailLongitude + numberOfResults;
        System.out.println(trailUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("X-RapidAPI-Host", "trailapi-trailapi.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "e283e8a640mshc6a45331cdfcaccp1b2b39jsne665ced35395");

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(trailUrl, HttpMethod.GET, httpEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        List<Trails> listOfTrails = new ArrayList<>();

        for(int i = 0; i < 10; i++)
        {
            String name = jsonNode.path("data").path(i).path("name").asText();
            String trailsUrl = jsonNode.path("data").path(i).path("url").asText();
            double distance = jsonNode.path("data").path(i).path("length").asInt();
            String description = jsonNode.path("data").path(i).path("description").asText();
            String difficulty = jsonNode.path("data").path(i).path("difficulty").asText();

            Trails trails = new Trails(name, trailsUrl, distance, description, difficulty);
            listOfTrails.add(trails);

        }
        return listOfTrails;
    }
}
