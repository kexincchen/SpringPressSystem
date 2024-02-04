package com.example.pressad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.pressad.mapper")
public class PressAdApplication {

	public static void main(String[] args) {
		SpringApplication.run(PressAdApplication.class, args);
	}

}
