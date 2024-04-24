package com.javatechie.security;

import org.springframework.web.bind.annotation.*;

import java.security.*;

@RestController
@RequestMapping("/secure/rest")
public class SecurityController {

    @GetMapping("/")
    public String home(){
        return "Hello Unauthenticated user";
    }

    @GetMapping("/user")
    public String user(Principal principal){
        return "Hello user : "+principal.getName();
    }

    @GetMapping("/admin")
    public String admin(Principal principal){
        return "Hello admin : "+principal.getName();
    }

}
