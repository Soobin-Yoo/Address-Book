package com.example.addbook.controller;

import com.example.addbook.dto.UserDTO;
import com.example.addbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user) { //요청객체
        return userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId) { //url(path)의 해당 userId 값을 매핑
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}") //getUserByUserId와 같은 url 값을 가지지만 다른 서비스를 수행
    public void updateUserAdd(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserAdd(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
