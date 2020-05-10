package com.example.idea.dao;

import com.example.idea.dataModel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("JDBC")
public class JDBCUserDao implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(JDBCUserDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    List<User> inMemUserList = new ArrayList<>();
    List<User> inMemHasOfferUserList = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        String query = "select id, name,food, rating, HASOFFER from u_user ";
        logger.info("getting users from database...");
        List<User> userList = jdbcTemplate.query(query, (resultSet, i) ->
                new User(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getString("food"),
                        resultSet.getInt("rating"),
                        resultSet.getBoolean("HASOFFER"))
        );
        logger.info("number of users: " + userList.size());
        inMemUserList.addAll(userList);
        return userList;
    }

    @Override
    public List<User> getAllHasOfferUsers() {
        String query = "select id, name,food, rating, hasOffer from u_user where hasOffer=? ";
        Boolean hasOffer = Boolean.FALSE;

        logger.info("getting has offer users from database...");
        List<User> userList = jdbcTemplate.query(query, new Object[]{hasOffer}, (resultSet, i) ->
                new User(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getString("food"),
                        resultSet.getInt("rating"),
                        resultSet.getBoolean("hasOffer"))
        );
        logger.info("number of has offer users: " + userList.size());
        inMemHasOfferUserList.addAll(userList);
        return userList;
    }

    public void negotiate(User userToNegotiate){
        if (inMemHasOfferUserList.contains(userToNegotiate)){
            //send notification to that user
        }
    }
}
