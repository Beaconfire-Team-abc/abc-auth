package com.bfs.abcauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @GetMapping("/userid")
    public String getUserId(HttpServletRequest request){
        System.out.println("getuserid");
        System.out.println((String)request.getSession().getAttribute("userId"));
        return (String)request.getSession().getAttribute("userId");
    }
}
