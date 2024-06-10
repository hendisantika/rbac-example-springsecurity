package com.example.repositories;

import com.example.models.User;

import java.util.List;

/**
 * @author tada
 */
public interface UserRepository {

    void register(User user, String roleName);

    List<User> findAll();

}
