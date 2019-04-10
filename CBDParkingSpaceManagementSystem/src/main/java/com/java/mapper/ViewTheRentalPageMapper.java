package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Deal;

/**
 * 用户租赁车位mapper
 * 
 * @author 刘佳秋
 *
 *         2019年3月25日
 */
public interface ViewTheRentalPageMapper extends BaseMapper<Deal> {

	/**
	 * 查询用户所有租赁车位 (分页)
	 * 
	 * @param userId  用户ID
	 * @param pageNum 当前页面
	 * @return
	 */
	@Select(value = "SELECT p.privatecarsid,p.equitiesid,p.area,d.startime,d.endtime,u.`name`,d.state FROM deal as d LEFT JOIN privatecars as p on d.privatecarsid = p.privatecarsid LEFT JOIN `user` as u "
			+ "on p.userid = u.userid where d.userid = ${userId} AND d.state = '已预定'  ORDER BY d.dealid DESC LIMIT ${pageNum},5")
	List<ViewTheRentalPageBean> getMyLeaseByUserId(@Param(value = "userId") int userId,
			@Param(value = "pageNum") int pageNum);
	
	/**
	 * 查询所有租赁车位
	 * @param userId 用户ID
	 * @return
	 */
	@Select(value="	SELECT p.equitiesid FROM deal as d LEFT JOIN privatecars as p on d.privatecarsid = p.privatecarsid LEFT JOIN `user` as u " + 
			"	on p.userid = u.userid where d.userid = ${userId} AND d.state = '已预定' ")
	List<ViewTheRentalPageBean> getAll(@Param(value="userId")int userId);
	
	
	
}
