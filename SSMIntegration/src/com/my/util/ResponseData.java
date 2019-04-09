package com.my.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装restful api响应数据工具类
 * @author 罗维
 *
 * 2019年3月12日
 */

public class ResponseData {

	private int code = 200; //响应状态码
	
	private String message = "ok"; //响应状态信息
	
	private Map<String,Object> data = new HashMap<String,Object>();//响应数据

	public ResponseData(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResponseData() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public static ResponseData ok() {
		return new ResponseData(200,"ok");
	}
	
	public static ResponseData noFound() {
		return new ResponseData(404,"no found resource");
	}
	/**
	 * 没有权限
	 * @return
	 */
	public static ResponseData unauthorized() {
		return new ResponseData(401,"unauthorized");
	}
}
