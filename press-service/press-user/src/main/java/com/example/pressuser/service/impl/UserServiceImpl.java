package com.example.pressuser.service.impl;

import com.example.pressresource.entity.User;
import com.example.pressuser.mapper.UserMapper;
import com.example.pressuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User registerNewUser(String nickname, String phoneNumber, String password) {
        User user = new User(nickname, phoneNumber, password);
        userMapper.insert(user);
        return user;
    }

    public void updateUserNickname(Long id, String nickname) {
        // Fetch the existing user record
        User user = userMapper.selectById(id);

        if (user == null) {
            throw new IllegalStateException("User not found with id: " + id);
        }
        // Update the nickname
        user.setNickname(nickname);
        // Persist the changes
        userMapper.updateById(user);
    }

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void authorizeByID(Long id, String role) {
        User user = userMapper.selectById(id);

        if (user == null) {
            throw new IllegalStateException("User not found with id: " + id);
        }
        // Update the nickname
        user.setRole(role);
        // Persist the changes
        userMapper.updateById(user);
    }
}
