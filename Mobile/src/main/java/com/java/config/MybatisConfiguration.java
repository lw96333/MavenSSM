package com.java.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;




/**
 * mybits配置
 * @author 罗维
 *
 * 2019年3月19日
 */
@Configuration
@MapperScan("com.java.mapper")
public class MybatisConfiguration {

	 /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
    	return new PaginationInterceptor();
    }
    
   
}
