package com.joseph.service;

import com.joseph.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);


    User getUserById(Long userId);

    void deleteUser(Long userId);
}
