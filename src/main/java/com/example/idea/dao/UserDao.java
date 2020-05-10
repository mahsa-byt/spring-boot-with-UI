package com.example.idea.dao;

import com.example.idea.dataModel.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    List<User> getAllHasOfferUsers();
}
