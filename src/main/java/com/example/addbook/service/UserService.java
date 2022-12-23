package com.example.addbook.service;

import com.example.addbook.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO insertUser(UserDTO user);

    List<UserDTO> getAllUsers();

    UserDTO getUserByUserId(String userId);

    void updateUserAdd(String userId, UserDTO user);

    void deleteUser(String userId);
}
