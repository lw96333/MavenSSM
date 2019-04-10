package com.java.mapper;

import com.java.bean.CbdBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Cbd;
import com.java.entity.Enterprise;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * cbd车位表 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface CbdMapper extends BaseMapper<Cbd> {
	
	
	/**
	 * 查询企业已租赁车位
	 * @param map 存放对象
	 * @return 已租赁车位数据
	 */
	@Select("select c.cbdid,c.address,c.areanumber,epc.contractnumber,epc.fromdate,epc.deadline from enterprisecontract as epc join cbd as c on epc.enterprisecontractid = c.enterprisecontractid join enterprise as ep on epc.enterpriseid = ep.enterpriseid where ep.enterpriseid = #{map.enterpriseId} order by c.cbdid desc limit #{map.newcurPage},#{map.pageSize}")
	List<CbdBean> getEnterpriseLeaseCarport(@Param("map") Map<String, Object> map);
	
	/**
	 * 得到总条数
	 * @param enterprise 企业用户实体类
	 * @return 影响行数
	 */
	@Select("select count(c.cbdid) from enterprisecontract as epc join cbd as c on epc.enterprisecontractid = c.enterprisecontractid join enterprise as ep on epc.enterpriseid = ep.enterpriseid where ep.enterpriseid = #{enterpriseid} ")
	int getSize(Enterprise enterprise);
	
}