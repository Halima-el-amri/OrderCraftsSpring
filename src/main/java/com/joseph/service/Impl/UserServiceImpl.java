package com.joseph.service.Impl;

import com.joseph.entity.User;
import com.joseph.repository.UserRepository;
import com.joseph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        // Check if the user exists and the password is correct
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        // Return null if login fails
        return null;
    }

    // You can add more methods as needed for user registration, etc.

    // For example:
    @Override
    public User registerUser(User user) {

        return userRepository.save(user);
    }

    // You may want to add more methods for managing users

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}