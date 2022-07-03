package com.microservice.swagger.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class ApiTest {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";

    }
}
