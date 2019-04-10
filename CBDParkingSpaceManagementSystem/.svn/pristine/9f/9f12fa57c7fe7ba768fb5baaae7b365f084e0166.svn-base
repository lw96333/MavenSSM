package com.java.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * mybits配置
 * @author 罗维
 *
 * 2019年3月19日
 */
@Configuration
@MapperScan("com.java.mapper")
public class MybatisConfiguration {
	
	@Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;


	 /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
    	return new PaginationInterceptor();
    }
    
    /**
     * 集成c3p0
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
    	dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        dataSource.setMaxPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setAcquireIncrement(3);
        dataSource.setInitialPoolSize(2);
        dataSource.setCheckoutTimeout(100000);
        dataSource.setIdleConnectionTestPeriod(1000);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);

    	return dataSource;
    }
}
