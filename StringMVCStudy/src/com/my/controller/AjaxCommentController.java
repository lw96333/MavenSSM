package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.javabean.CommentBean;
/**
 * 
 * @author 49160
 *
 */
@Controller
public class AjaxCommentController {

	@RequestMapping("ajax")
	@ResponseBody//ajax注解用于将返回的数据转换为json格式
	public CommentBean ajax(CommentBean commentBean) {
		System.out.println(commentBean);
		return commentBean;
	}
}
