package com.study.example.study.controller;

import com.study.example.study.controller.domain.User;
import com.study.example.study.controller.domain.UserInfoRequest;
import com.study.example.study.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    private final UserRepository userRepository;

    public PostController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserInfoRequest postMethod(@RequestBody UserInfoRequest request){
        return request;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
