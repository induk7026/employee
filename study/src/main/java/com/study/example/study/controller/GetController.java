package com.study.example.study.controller;

import com.study.example.study.controller.domain.UserInfoRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @GetMapping("/getMethod")
    public String getRequest(@RequestParam String id, @RequestParam String pw){
        System.out.println(id);
        System.out.println(pw);
        return "Hi getMethod";
    }

    @GetMapping("/userInfo")
    public UserInfoRequest getRequest(UserInfoRequest request){
        System.out.println(request.toString());
        return request;
    }
}
