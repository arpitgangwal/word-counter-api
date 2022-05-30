package com.word.counter.controller;

import com.word.counter.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @GetMapping(path = "/jwt-token/{userName}")
   public String generateToken(@PathVariable ("userName") String userName){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, ""));
                return jwtUtil.generateToken(userName);
    }
}
