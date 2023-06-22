package com.jrinehuls.usda.controller;

import com.jrinehuls.usda.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ToDoController {

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
}
