package com.example.demo.service;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
    public void addUser(User user);
    public void deleteUser(String userId);
    public void updateUser(User user);
    public User getUserById(String userId);
    public List<User> getAllUsers();

}
