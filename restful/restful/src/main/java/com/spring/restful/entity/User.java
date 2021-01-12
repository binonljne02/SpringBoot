package com.spring.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;
}
