package com.student.service;

import com.student.entity.StudentEntity;
import com.student.util.PageBean;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;


public interface StudentService extends IService<StudentEntity>{
	PageBean<StudentEntity> getAllPersonalSalePageBean(Map<String, Object> condtion);

    
}