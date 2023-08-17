package com.skillup.azure.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping( "/home" )
    public String home( @AuthenticationPrincipal(expression = "claims['name']") String name ) {
        return String.format( "Hello %s!  welcome to the Security app", name);
    }
}