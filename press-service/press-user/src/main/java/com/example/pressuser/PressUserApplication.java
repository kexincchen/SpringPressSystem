package com.example.pressuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.pressuser.mapper")
public class PressUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PressUserApplication.class, args);
    }

}
