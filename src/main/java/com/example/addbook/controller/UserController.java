package com.example.addbook.controller;

import com.example.addbook.Entity.Users;
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
    public Users insertUser(@RequestBody Users user) { //요청객체
        return userRepository.save(user);
    }

    @GetMapping("")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users getUserByUserId(@PathVariable String id) { //url(path)의 해당 id 값을 매핑
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}") //getUserByUserId와 같은 url 값을 가지지만 다른 서비스를 수행
    public void updateUserAdd(@PathVariable String id, @RequestBody Users user) {
        userRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setPasswd(user.getPasswd());
                    userEntity.setTel(user.getTel());
                    return userRepository.save(userEntity);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
