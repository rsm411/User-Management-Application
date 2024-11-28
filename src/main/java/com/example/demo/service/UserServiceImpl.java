package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        if (userRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistsException("User already exists with id: " + user.getUserId());
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new UserNotFoundException("User not found with id: " + user.getUserId());
        }
        userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}