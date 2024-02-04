package com.example.pressuser.controller;

import com.example.pressresource.entity.User;
import com.example.pressuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestParam String nickname, @RequestParam String phoneNumber, @RequestParam String password) {
        User user = userService.registerNewUser(nickname, phoneNumber, password);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully. \nID: " + user.getUserid());
    }

    @PutMapping("/{id}/update-nickname")
    public ResponseEntity<String> updateUserNickname(@PathVariable Long id, @RequestParam String nickname) {
        userService.updateUserNickname(id, nickname);
        return ResponseEntity.ok("User nickname updated successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}/authorize")
    public ResponseEntity<String> updateUserRole(@PathVariable Long id, @RequestParam String role) {
        userService.authorizeByID(id, role);
        return ResponseEntity.ok("User role updated successfully");
    }
}