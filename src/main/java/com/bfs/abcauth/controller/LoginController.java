package com.bfs.abcauth.controller;

import com.bfs.abcauth.entity.User;
import com.bfs.abcauth.repository.UserRepository;
import com.bfs.abcauth.security.CookieUtil;
import com.bfs.abcauth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {
    private static final String jwtTokenCookieName = "TEAMABC-JWT-TOKEN";
    private static final String signingKey = "signingKey";

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value="/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String username, String password, String redirect, Model model) {

        List<User> users = userRepository.findByEmailAndPassword(username , password);
        if (users == null || users.size() == 0){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
        User user = users.get(0);
        String userId = user.getUserId().toString();
        request.getSession().setAttribute("userId", userId);
        HashMap<String, String> payLoad = new HashMap<>();

        payLoad.put("userId", userId);

        String token = JwtUtil.generateToken(signingKey, payLoad);
        CookieUtil.create(response, jwtTokenCookieName, token, false, -1, "localhost");

        return "redirect:" + "http://localhost:3000/";
    }

}
