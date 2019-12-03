package com.ilisi.roommatebackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping()
    public ResponseEntity<String> home() {

        return new ResponseEntity<>("Event Planner API Version " , HttpStatus.OK);
    }

}