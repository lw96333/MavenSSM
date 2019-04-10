package com.java.restcontroller;
/**
 * 性能统计控制器
 * @author 张冀川
 *
 * 2019年3月28日
 */



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.entity.Responsetime;
import com.java.service.ResponsetimeService;
import com.java.util.ResponseData;
@RestController
public class ResponseTimeController {
	@Autowired
	private ResponsetimeService responsetimeService;
	/**
	 * 显示性能统计
	 * @return
	 */
	@RequestMapping("showResponsetime")
	public ResponseData showResponsetime(){
		Page<Responsetime> page = new Page<Responsetime>(1,100);
		EntityWrapper<Responsetime> ew = new EntityWrapper<Responsetime>();
		ew.orderBy("id",false);
		List<Responsetime> list = responsetimeService.selectList(null);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("pge", list);

		return responseData;
	}
}

