package com.example.addbook.controller;

import com.example.addbook.Entity.UserEntity;
import com.example.addbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public UserEntity insertUser(@RequestBody UserEntity user) { //요청객체
        return userRepository.save(user);
    }

    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public UserEntity getUserByUserId(@PathVariable String userId) { //url(path)의 해당 userId 값을 매핑
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}") //getUserByUserId와 같은 url 값을 가지지만 다른 서비스를 수행
    public void updateUserAdd(@PathVariable String userId, @RequestBody UserEntity user) {
        userRepository.findById(userId)
                .map(userEntity -> {
                    userEntity.setPasswd(user.getPasswd());
                    userEntity.setUserTel(user.getUserTel());
                    return userRepository.save(userEntity);
                })
                .orElseGet(() -> {
                    user.setUserId(userId);
                    return userRepository.save(user);
                });
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteById(userId);
    }
}
