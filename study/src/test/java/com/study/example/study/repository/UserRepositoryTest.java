package com.study.example.study.repository;


import com.study.example.study.StudyApplication;
import com.study.example.study.controller.domain.Item;
import com.study.example.study.controller.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = User.builder()
                .account("TestUser01")
                .email("test@test.com")
                .phone("010-4331-7026")
                .createdAt(LocalDateTime.now())
                .createdBy("admin")
                .updatedAt(LocalDateTime.now())
                .createdBy("admin")
                .build();

        User newUser = userRepository.save(user);
        System.out.println(newUser.toString());

    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findByAccount("TestUser01")
                .orElseThrow(NullPointerException::new);

        System.out.println(user.toString());
        user
            .getOrderDetails()
            .forEach(
                orderDetail -> {
                    System.out.println("orderDetail:" + orderDetail);
                    Item item = orderDetail.getItem();
                    System.out.println(item);
                }
            );
        assertThat(user.getAccount()).isEqualTo("TestUser01");
    }

    @Test
    @Transactional
    public void update(){
        User user = userRepository.findById(6L)
                .orElseThrow(NullPointerException::new);
        user.setAccount("PPPP");
        userRepository.save(user);
        assertThat(user.getAccount()).isEqualTo("PPPP");
    }
}