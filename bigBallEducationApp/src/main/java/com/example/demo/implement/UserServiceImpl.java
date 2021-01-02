package com.example.demo.implement;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;
    @Override
    public List<User> getAllUsers() {
       return usermapper.getAllUser();
    }

    @Override
    public int addUser(User user) {
        return usermapper.addUser(user);
    }

    @Override
    public User getUserByPhoneNumber(String Number) {
       return usermapper.getUserByPhoneNumber(Number);
    }

    @Override
    public int updateUser(User user) {
        return usermapper.updateUser(user);
    }

    @Override
    public int updateUserBaseInfo(User user) {

        return usermapper.updateUserWithBaseInfo(user);
    }
}
