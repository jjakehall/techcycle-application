package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GoogleMaps {

    @Value("${googlemaps.api.key}")
    String apiKey;

    @Value("${googlemaps.geocode.url}")
    String url;

    public String getLatitudeLongitude(String address) throws JsonMappingException, JsonProcessingException {

        String url = this.url + address + this.apiKey;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String body = "";
        HttpEntity<String> httpEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        String latitude = jsonNode.path("results").path(0).path("geometry").path("location").path("lat").asText();
        String longitude = jsonNode.path("results").path(0).path("geometry").path("location").path("lng").asText();

        double latDouble = Double.parseDouble(latitude);
        double lonDouble = Double.parseDouble(longitude);

        return latDouble + "&" + lonDouble;

    }

    public String getBounds(String latLon)
    {
        //1 degree latitude = 69 miles
        String[] bounds = latLon.split("&");
        double latitude = Double.parseDouble(bounds[0]);
        double longitude = Double.parseDouble(bounds[1]);

        double latChange = 0.5;
        double lonChange = Math.abs(Math.cos(latitude*(Math.PI/180)));
        double latMin = latitude - latChange;
        double lonMin = longitude - lonChange;
        double latMax = latitude + latChange;
        double lonMax = longitude + lonChange;

        return latMin + "," + lonMin + "," + latMax + "," + lonMax;
    }

}
