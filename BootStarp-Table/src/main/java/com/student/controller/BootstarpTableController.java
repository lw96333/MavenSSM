package com.student.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentEntity;
import com.student.service.StudentService;
import com.student.util.PageBean;

@RestController // 等价于Controller+ResponeBoy
public class BootstarpTableController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("bootstarp")
	public PageBean<StudentEntity> bootStarpTable(@RequestParam(value="pageSize") Integer pageSize,@RequestParam(value="curPage")  Integer curPage,@RequestParam(value="name")  String name/*, Integer age,
			String address, String phone*/) {

		Map<String, Object> condition = new HashMap<>();
		if("".equals(name)) {
			condition.put("name", null);
		}else {
			condition.put("name", name);
		}
		condition.put("pageSize", pageSize);
		condition.put("curPage", curPage);
		
		condition.put("age", null);
		condition.put("address", null);
		condition.put("phone", null);

		PageBean<StudentEntity> pageBean = studentService.getAllPersonalSalePageBean(condition);

		return pageBean;
	}
}
