package com.javatechie.security;

import org.springframework.web.bind.annotation.*;

import java.security.*;

@RestController
@RequestMapping("/secure/rest")
public class SecurityController {

    @GetMapping("/hello")
    public String hello(Principal principal){
        return "Hello "+principal.getName();
    }

}
