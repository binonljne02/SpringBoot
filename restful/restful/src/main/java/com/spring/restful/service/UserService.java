package com.spring.restful.service;

import java.util.List;
import java.util.Optional;

import com.spring.restful.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService<T> {
    public List<User> getListUser();
    public Optional<T> getUserByID(int id);        
    
}
