package com.example.idea.controller;

import com.example.idea.dataModel.User;
import com.example.idea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class Controller {

    private final UserService userService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/others")
    public ResponseEntity<List<User>> getAllOtherUsers(Model model) {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/get/hasoffer")
    public List<User> getAllHasOfferUsers() {
        return userService.getHasOfferUsers();
    }


    @GetMapping
    @RequestMapping("/position")
    public String generateRandomPosition() {
        return userService.generatePositionByChance();
    }
}
