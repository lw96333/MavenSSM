package com.java.mapper;

import com.java.bean.EnterprisecontractBean;
import com.java.entity.Enterprise;
import com.java.entity.Enterprisecontract;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 企业合约 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface EnterprisecontractMapper extends BaseMapper<Enterprisecontract> {

	/**
	 * 分页显示所有企业合约
	 * @param map 
	 * @return
	 */
	@Select("select en.enterprisecontractid,en.contractnumber,ee.contactperson,ee.phone,en.fromdate,en.deadline,en.price FROM enterprisecontract as en JOIN enterprise as ee on en.enterpriseid=ee.enterpriseid LIMIT #{newcurPage},#{pageSize}")
	public List<EnterprisecontractBean> findAllContract(Map<String,Integer> map);
	
	/**
	 * 新增企业合约
	 * @param eBean 参数bean
	 * @return 影响行数
	 */
	@Insert("insert into enterprisecontract value(null,#{enterpriseid},null,#{contractnumber},#{fromdate},#{deadline},#{price},null,null)")
    @Options(useGeneratedKeys = true,keyProperty = "enterprisecontractid",keyColumn = "enterprisecontractid")
	public int addEnterprisecontract(Enterprisecontract eBean);
	
	/**
	 * 得到总条数
	 * @return 返回保存的总条数
	 */
	@Select("select COUNT(en.enterprisecontractid) as enterprisecontractid FROM enterprisecontract as en JOIN enterprise as ee on en.enterpriseid=ee.enterpriseid")
	public EnterprisecontractBean getsize();
	
	
}