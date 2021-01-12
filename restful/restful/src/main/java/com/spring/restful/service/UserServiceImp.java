package com.spring.restful.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.restful.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService<User> {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Duong Tuan Phuong", "abc@gmail.com", "0968525112", "avatar.jpg", "1234567"));
        users.add(new User(2, "Duong Van Teo", "xyz@gmail.com", "1231241241", "dsaa.jpg", "4242424"));
        users.add(new User(3, "Nguyen Van Vu", "dasda@gmail.com", "09612415112", "avatar.jpg", "155211"));
        users.add(new User(4, "Tran Van A", "xxxx@gmail.com", "0968asdas12", "avav.jpg", "1223567"));
        users.add(new User(5, "Cai Gi Day", "agggc@gmail.com", "0968524212", "avavvvvv.jpg", "123dddddd"));
    }

    @Override
    public List<User> getListUser() {
        // TODO Auto-generated method stub
        return users;
    }

    @Override
    public Optional<User> getUserByID(int id) {
        // TODO Auto-generated method stub
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    
}
