package com.java.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 服务器启动
 * @author 罗维
 *
 * 2019年3月19日
 */
@SpringBootApplication
@ComponentScan(basePackages="com.java")
@EnableScheduling						//启动任务
@EnableTransactionManagement			//事务管理
@EnableCaching							//缓存
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")//mybatis-plus
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
