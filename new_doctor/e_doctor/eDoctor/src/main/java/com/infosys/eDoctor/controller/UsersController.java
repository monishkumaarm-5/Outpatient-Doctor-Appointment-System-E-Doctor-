package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Users;
import com.infosys.eDoctor.request.LoginRequest;
import com.infosys.eDoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public Users addUser(@RequestBody Users user) {
        if (user.getUserType() == null || user.getUserType().isEmpty()) {
            user.setUserType("patient");
        }
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
}