package com.idou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.idou.modules.*.dao")
public class ZhiyiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhiyiApplication.class, args);
	}
}
