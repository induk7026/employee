package com.study.example.study.controller.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserInfoRequest {

    private String account;
    private String email;
    private int page;

}
