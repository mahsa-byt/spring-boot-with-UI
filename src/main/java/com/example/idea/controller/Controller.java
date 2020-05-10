package com.example.idea.controller;

import com.example.idea.dataModel.User;
import com.example.idea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

//    @GetMapping
//    @MessageMapping("/get/others")
    @RequestMapping(value = "/others", produces = MediaType.APPLICATION_XML_VALUE)
    public String getAllOtherUsers(Model model) {
        model.addAttribute("others", userService.getAllUsers());
        //return new User(UUID.randomUUID(), "mahsa");
        return "xmlTemplate";
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
