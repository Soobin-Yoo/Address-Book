package com.example.addbook.service.impl;

import com.example.addbook.dto.UserDTO;
import com.example.addbook.repository.UserRepository;
import com.example.addbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDTO getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserAdd(String userId, UserDTO user) {
        userRepository.updateUserAdd(userId, user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }
}
