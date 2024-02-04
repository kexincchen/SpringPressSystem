package com.example.pressnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.pressnews.mapper")
public class PressNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PressNewsApplication.class, args);
    }

}
