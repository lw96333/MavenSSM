package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.javabean.GoodsBean;
/**
 * 数据转换
 * @author 49160
 *
 */
@Controller
public class GoodsController {

	@RequestMapping("goods")
	public String goods(GoodsBean goodsBean) {
		
		
		return "GoodsOk";
	}
}
