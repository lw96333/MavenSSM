package com.java.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.java")
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")//mybatis-plus
@EnableTransactionManagement
public class MobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

}
