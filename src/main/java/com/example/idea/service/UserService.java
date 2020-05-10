package com.example.idea.service;

import com.example.idea.dao.UserDao;
import com.example.idea.dataModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public List<User> getHasOfferUsers(){
        return userDao.getAllHasOfferUsers();
    }

    public String generatePositionByChance(){
        double chance = Math.random();
        if (chance > 0 && chance < 0.02)
            return "KOON";
        else
            return "KOS";
    }
}
