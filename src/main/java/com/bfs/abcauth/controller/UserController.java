package com.bfs.abcauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @GetMapping("/userid")
    public String getUserId(HttpServletRequest request){
        return (String) request.getSession().getAttribute("userId");
    }
}
