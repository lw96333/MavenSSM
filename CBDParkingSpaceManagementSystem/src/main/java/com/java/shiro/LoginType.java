package com.java.shiro;

/**
 * 登录类型枚举（用户和管理员）
 * @author 罗维
 *
 * 2019年3月23日
 */
public enum LoginType {
	/**
	 * 用户判断端前台用户登录
	 */
    FORTEND("Fortend"),
    /**
     * 用户判断后台用户登录
     */
    BACKSTAGE("Backstage");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}