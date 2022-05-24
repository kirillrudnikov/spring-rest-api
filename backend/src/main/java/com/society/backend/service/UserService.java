package com.society.backend.service;

import com.society.backend.entity.User;

import java.util.List;

public interface UserService {

    List<User> fetchAllUsers();
    User fetchUser(Long id);
    User saveUser(User user);
    Boolean deleteUser(User user);

}