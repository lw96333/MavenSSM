package com.java.util;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
/**
 * 自定义日志注解
 * @author 张冀川
 *
 * 2019年3月27日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogStatistics {
    logType[] operation();// 记录日志操作（添加、修改、删除  登录）
    
    UserType[] userPower() default{}; //记录前台还是后台
    
    String operatecontent() default ""; //操作内容

}
