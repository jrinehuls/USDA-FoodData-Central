package com.jrinehuls.usda.controller;

import com.jrinehuls.usda.model.Food;
import com.jrinehuls.usda.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FoodDataController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDo> getToDo(@PathVariable("id") String id) {
        String theUrl = "https://jsonplaceholder.typicode.com/todos/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "UVi63ywl7bpzs0NNXkF6ElTikJNlhXWXvq9zgL9N");

        ResponseEntity<ToDo> response = restTemplate.exchange(theUrl, HttpMethod.GET, null, ToDo.class);
        return new ResponseEntity<ToDo>(response.getBody(), HttpStatus.OK);
    }

    @GetMapping("food/{fdcId}")
    public ResponseEntity<Food> getFood(@PathVariable("fdcId") Long id) {
        String theUrl = "https://api.nal.usda.gov/fdc/v1/food/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "UVi63ywl7bpzs0NNXkF6ElTikJNlhXWXvq9zgL9N");

        HttpEntity<Food> entity = new HttpEntity<>(headers);

        ResponseEntity<Food> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, Food.class);
        return new ResponseEntity<Food>(response.getBody(), HttpStatus.OK);
    }

}