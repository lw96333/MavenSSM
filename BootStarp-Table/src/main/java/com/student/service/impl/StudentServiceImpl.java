package com.student.service.impl;

import com.student.dao.StudentDao;
import com.student.entity.StudentEntity;
import com.student.service.StudentService;
import com.student.util.PageBean;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@Transactional(transactionManager = "transactionManager")
@Rollback(value = false)
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,StudentEntity> implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public PageBean<StudentEntity> getAllPersonalSalePageBean(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		int curPage = (Integer) condition.get("curPage");
		int pageSize = (Integer) condition.get("pageSize");
		List<StudentEntity> list = studentDao.getAllStudent(condition);
		
		int tolPetSize = studentDao.getTolSize(condition);
		
		PageBean<StudentEntity> pageBean = new PageBean<StudentEntity>();

		// 封装分页对象
		/*
		 * 当前页数
		 */
		pageBean.setCurPage(curPage);
		// 总条数
		pageBean.setTolSize(tolPetSize);
		// 每页显示条数
		pageBean.setPageSize(pageSize);
		// 显示数据
		pageBean.setDatas(list);

		return pageBean;
	}
   

	
}