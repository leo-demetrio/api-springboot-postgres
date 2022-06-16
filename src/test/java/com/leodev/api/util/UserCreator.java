package com.leodev.api.util;

import com.leodev.api.entities.User;

public class UserCreator {
    public static User createUser(){
        return User.builder()
                .name("Leo")
                .email("leo@gmail.com")
                .phone("2222-2222")
                .password("123")
                .build();
    }

    public static User createUserValid() {
        return User.builder()
                .id(1L)
                .name("Leo")
                .email("leo@gmail.com")
                .phone("2222-2222")
                .password("123")
                .build();
    }
}
