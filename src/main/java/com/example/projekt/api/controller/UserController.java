package com.example.projekt.api.controller;

import com.example.projekt.api.model.User;
import com.example.projekt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    public UserController(UserService userService){

        this.userService = userService;
        logger.debug("UserController initialized with UserService.");
    }



}
