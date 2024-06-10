package com.example.services;

import com.example.models.User;

import java.util.List;

/**
 * @author tada
 */
public interface UserService {

    void register(User user, String roleName);

    List<User> findAll();

}
