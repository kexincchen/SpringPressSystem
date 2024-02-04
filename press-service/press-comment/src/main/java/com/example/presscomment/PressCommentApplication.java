package com.example.presscomment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.presscomment.mapper")
public class PressCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PressCommentApplication.class, args);
    }

}