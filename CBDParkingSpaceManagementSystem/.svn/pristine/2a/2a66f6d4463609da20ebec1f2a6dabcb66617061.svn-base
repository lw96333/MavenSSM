package com.java.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 用于判断登录用户
 * @author 罗维
 *
 * 2019年3月23日
 */
public class CustomizedToken extends UsernamePasswordToken {

	/**
	 * 登录类型，判断是用户登录还是管理员登录
	 */
    private String loginType;

    public CustomizedToken(final String username, final String password,String loginType) {
        super(username,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}