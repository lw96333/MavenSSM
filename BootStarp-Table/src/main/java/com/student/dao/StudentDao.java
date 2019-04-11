package com.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.entity.StudentEntity;

public interface StudentDao  extends BaseMapper<StudentEntity>{
	
	
	@Select("<script>"
			+ "select count(*) from"
			+ " t_student where 1=1"
			+ "<if test='name != null'>"
			+ " and name like '%${name}%'</if>"
			+ "<if test='age != null'>"
			+ " and age = #{age}</if>"
			+ "<if test='phone != null'>"
			+ " and phone=#{phone}</if>"
			+ "<if test='address != null'>"
			+ " and address like #{address}</if>"
			+ "</script>")
    int getTolSize(Map<String , Object> condition);
	

	@Select("<script>"
			+ "select * from"
			+ " t_student where 1=1"
			+ "<if test='name != null'>"
			+ " and name like '%${name}%'</if>"
			+ "<if test='age != null'>"
			+ " and age = #{age}</if>"
			+ "<if test='phone != null'>"
			+ " and phone=#{phone}</if>"
			+ "<if test='address != null'>"
			+ " and address like #{address}</if>"
			+ " limit ${curPage},${pageSize}</script>")
    List<StudentEntity> getAllStudent(Map<String, Object> condition);

}