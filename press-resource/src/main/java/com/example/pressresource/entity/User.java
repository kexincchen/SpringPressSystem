package com.example.pressresource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@TableName("Users")
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long userid;
    private String nickname;  // TODO: set username unique
    @TableField("PhoneNumber")
    private String phoneNumber;
    @TableField("LastLogin")
    private Date lastLogin;
    private String password;  // TODO: Encrypt then set
    private String role;
    @TableField("AvatarUrl")
    private String avatarURL;

    public User(String nickname, String phoneNumber){
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.role = "USER";
    }

    public User(String nickname, String phoneNumber, String password){
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = "USER";
    }

    public User(String nickname, String password, Role role){
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role.toString();
    }

    public String getUsername() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setUsername(String nickname) {
        this.nickname = nickname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setRole(String role) {
        List<String> roles = Arrays.stream(Role.values()).map(Objects::toString).toList();
        if (roles.contains(role)){
            this.role = role;
        } else {
            System.out.println("Error: setting role invalid");
        }
    }
}

