package com.example.pressuser.service;


import com.example.pressresource.entity.User;

import java.util.List;

public interface UserService {

    User registerNewUser(String nickname, String phoneNumber, String password);

    void updateUserNickname(Long id, String nickname);

    List<User> getAllUsers();

    User findByUsername(String username);

    void authorizeByID(Long id, String role);



}