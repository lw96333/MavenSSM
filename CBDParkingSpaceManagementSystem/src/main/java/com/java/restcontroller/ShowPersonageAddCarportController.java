package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.entity.Privatecars;
import com.java.entity.User;
import com.java.service.PrivatecarsService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 查看个人添加车位信息
 * @author 郑升亮
 *
 *2019年3月22日
 */
@RestController
@Log4j
public class ShowPersonageAddCarportController {
	
	@Autowired
	private PrivatecarsService prService; 
	/**
	 * 按用户ID 查询 私人车位数据
	 * @param pageNum 当前页
	 * @return 返回显示数据
	 */
	@RequestMapping("showPersonageAddCarport")
	public ResponseData showPersonageAddCarport(Integer pageNum,HttpSession session ) {
		log.info("收到查询 私人车位数据请求");
		ResponseData responseData = new ResponseData();
		EntityWrapper<Privatecars> entityWrapper  = new EntityWrapper<Privatecars>();
		
		//获取登陆用户的ID
		User users = (User) session.getAttribute("user");
		int userid = users.getUserid();
		entityWrapper.eq("userid", userid);
		entityWrapper.orderBy("privatecarsid",false);
		Page<Privatecars> page = new Page<Privatecars>(pageNum,5);
		Page page2 = prService.selectPage(page,entityWrapper);
		
		responseData.getData().put("page2", page2);
		return responseData;
	}
	/**
	 *  根据ID删除
	 * @param privatecarsid 车位ID
	 * @return 返回删除后数据
	 */
	@LogStatistics(operatecontent="根据ID删除",operation=logType.删除)
	@RequestMapping("deletePersonageAddCarport")
	public ResponseData deletePersonageAddCarport(int privatecarsid,HttpSession session) {
		log.info("收到删除私人车位请求");
		EntityWrapper<Privatecars> entityWrapper  = new EntityWrapper<Privatecars>();
		entityWrapper.eq("privatecarsid", privatecarsid);
		prService.delete(entityWrapper);
		
		return showPersonageAddCarport(1,session);
	}
	
}
