package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.java.bean.PersonalAddedParkingBean;
import com.java.entity.Privatecars;

import lombok.val;

/**
 * 后台审批个人添加车位Mapper
 * 
 * @author 刘佳秋
 *
 *         2019年3月21日
 */
public interface BackstagePrivateParkingSpaceExaminationAndApprovalMapper extends BaseMapper<Privatecars> {
	/**
	 * 查找需要审批私人车位的用户带分页
	 * 
	 * @param pageNum
	 *            当前页数
	 * @return 需要审批的集合
	 */
	@Select(value = "select u.userid,"
			+ "p.privatecarsid,"
			+ "p.equitiesid,"
			+ "p.area,"
			+ "u.name,"
			+ "u.realname,"
			+ "u.identitynumber,"
			+ "u.phone"
			+ " from privatecars as p left join user as u "
			+ "on u.userid = p.userid "
			+ "WHERE state = '待审核' ORDER BY u.userid DESC LIMIT ${pageNum},5")
	List<PersonalAddedParkingBean> queryApprovalParking(@Param("pageNum") int pageNum);

	/**
	 * 查询所有待审核的个人车位
	 * 
	 * @return
	 */
	@Select(value = "SELECT privatecarsid FROM privatecars WHERE state = '待审核'")
	List<PersonalAddedParkingBean> getAllPersonalAddedParking();

	/**
	 * 用户私人车位审核通过
	 * 
	 * @param privatecarsid
	 *            用户私人车位ID
	 * @return
	 */
	@Update(value = "UPDATE privatecars set state = '审核通过' WHERE privatecarsid = #{privatecarsid}")
	int updateAuditPass(@Param("privatecarsid") int privatecarsid);

	/**
	 * 用户私人车位审核不通过
	 * 
	 * @param privatecarsid
	 *            用户私人车位ID
	 * @return
	 */
	@Update(value = "UPDATE privatecars set state = '审核不通过' WHERE privatecarsid = #{privatecarsid}")
	int updateAuditFailed(@Param("privatecarsid") int privatecarsid);

}
