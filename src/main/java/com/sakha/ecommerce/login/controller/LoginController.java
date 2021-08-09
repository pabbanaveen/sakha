package com.sakha.ecommerce.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*")
public class LoginController {

    @GetMapping("/")
    public String checkMVC() {
        return "(<h1>hello</h1>  <button onClick=\"http://localhost:8080/registeration\">Send</button>)";
    }
}
