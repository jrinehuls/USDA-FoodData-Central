package com.jrinehuls.usda.controller;

import com.jrinehuls.usda.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@RestController
public class FoodDataController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("food/{fdcId}")
    public ResponseEntity<?> getFood(@PathVariable("fdcId") Long id, @RequestHeader(name = "x-api-key", required = false) String token) {

        String url = "https://api.nal.usda.gov/fdc/v1/food/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", token);

        HttpEntity<Food> requestEntity = new HttpEntity<>(headers);

        try {
            Food response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Food.class).getBody();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getResponseBodyAsByteArray(), e.getStatusCode());
        }
    }

}