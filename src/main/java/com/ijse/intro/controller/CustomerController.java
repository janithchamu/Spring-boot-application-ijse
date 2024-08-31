package com.ijse.intro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello User";
    }

    @GetMapping("/helloAdmin")
    public String getAdmin(){
        return "Hello Admin";
    }

    @PostMapping("/hello")
    public String postRequest(){
        return "This is a Post End Point";
    }


}
