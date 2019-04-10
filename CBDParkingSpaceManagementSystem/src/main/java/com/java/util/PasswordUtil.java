package com.java.util;
 
import java.security.MessageDigest;
import java.util.Random;
 
import org.apache.commons.codec.binary.Hex;
/**
 * 密码加密
 * @author 罗维
 *
 * 2019年3月21日
 */
public class PasswordUtil {
	/**
	 * 生成含有盐的密码
	 */
	public static String generate(String userName,String password) {
 		StringBuilder sb = new StringBuilder(16);
 		sb.append(userName).append(password);
 		int len = sb.length();
 		int numone = 16;
 		if (len < numone) {
 			for (int i = 0; i < numone - len; i++) {
 				sb.append("0");
 			}
 		}
 		String salt = sb.toString();

 		password = md5Hex(password + salt);
 		char[] cs = new char[48];
 		int numtwo = 48;
 		int numtree = 3;
 		for (int i = 0; i < numtwo; i += numtree) {
 			cs[i] = password.charAt(i / 3 * 2);
 			char c = salt.charAt(i / 3);
 			cs[i + 1] = c;
 			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
 		}
		return new String(cs);
	}
 
 
	/**
	 * 获取十六进制字符串形式的MD5摘要
	 */
	public static String md5Hex(String src) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest(src.getBytes());
			return new String(new Hex().encode(bs));
		} catch (Exception e) {
			return null;
		}
	}
}
