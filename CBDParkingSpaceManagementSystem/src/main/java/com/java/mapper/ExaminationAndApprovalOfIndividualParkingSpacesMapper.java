package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.java.bean.BuyerInformationBean;
import com.java.bean.SellcarsBean;
import com.java.bean.SellingParkingInformationBean;
import com.java.entity.Purchasecars;

/**
 * 后台审批个人买卖车位Mapper
 * 
 * @author 刘佳秋
 *
 *         2019年3月21日
 */
public interface ExaminationAndApprovalOfIndividualParkingSpacesMapper extends BaseMapper<Purchasecars> {

	/**
	 * 查询所有出售人信息
	 * 
	 * @param pageNum
	 *            当前页数
	 * @return
	 */
	@Select(value = "SELECT pri.equitiesid,pri.privatecarsid," + "pur.purchasecarsid,pri.area," + "u.realname," + "u.phone,"
			+ "u.identitynumber,u.userid " + "FROM purchasecars as pur LEFT join "
			+ "privatecars as pri on pur.sellcarsid = pri.privatecarsid "
			+ "LEFT join `user` as u on pri.userid = u.userid where pur.state = '同意出售' ORDER BY pur.purchasecarsid DESC LIMIT ${pageNum},5")
	List<SellingParkingInformationBean> selectSellerInformation(@Param("pageNum") int pageNum);

	/**
	 * 查询所有待审核的买卖车位
	 * 
	 * @return
	 */
	@Select(value = "select purchasecarsid from purchasecars where state = '同意出售'")
	List<Purchasecars> getAllPurchasecars();

	/**
	 * 查询所有购买车位人信息
	 * 
	 * @param pageNum
	 *            当前页数
	 * @return
	 */
	@Select(value = "SELECT pur.purchasecarsid,`user`.realname,`user`.phone,`user`.userid "
			+ "FROM purchasecars as pur LEFT JOIN `user` on pur.userid = `user`.userid where pur.state = '同意出售' ORDER BY pur.purchasecarsid DESC LIMIT ${pageNum},5")
	List<BuyerInformationBean> selectBuyerInformation(@Param("pageNum") int pageNum);

	/**
	 * 审核通过，改变数据库状态字段为：审核通过
	 * 
	 * @param purchasecarsid
	 *            购买车位表ID
	 * @return
	 */
	@Update(value = "UPDATE purchasecars set state = '查看合同' WHERE sellcarsid = #{purchasecarsid}")
	int updateAuditPass(@Param("purchasecarsid") int purchasecarsid);
	
	/**
	 * 审核通过，Sellcars表状态改为查看合同
	 * @param purchasecarsid
	 * @return
	 */
	@Insert(value="UPDATE sellcars set state = '查看合同' WHERE privatecarsid = #{purchasecarsid}")
	int insertSellcars(@Param("purchasecarsid") int purchasecarsid);

	/**
	 * 审核不通过，删除数据库状态字段
	 * 
	 * @param purchasecarsid
	 *            购买车位表ID
	 * @return
	 */
	@Delete(value = "DELETE FROM purchasecars WHERE purchasecarsid = ${purchasecarsid}")
	int updateAuditFailed(@Param("purchasecarsid") int purchasecarsid);
	/**
	 * 审核不通过，根据车位ID修改字段
	 * @param privatecarsid 车位ID
	 * @return
	 */
	@Update(value = "UPDATE sellcars set state = '等待出售', message='' WHERE privatecarsid = ${privatecarsid} and state = '同意出售'")
	int deleteSellcarsByprivatecarsid(@Param(value="privatecarsid")int privatecarsid);
	
	/**
	 * 审核通过，改变数据库状态字段为：等待出售
	 * 
	 * @param privatecarsid
	 *            车位表ID
	 * @return
	 */
	@Update(value = "UPDATE privatecars set state = '等待出售' WHERE privatecarsid = ${privatecarsid}")
	int updatePrivatecarsById(@Param(value="privatecarsid")int privatecarsid);
	
	
}
