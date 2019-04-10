package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.bean.BuyHistoryBean;
import com.java.bean.BuyerInformationBean;
import com.java.bean.SelectContractBuyBean;
import com.java.bean.SelectContractShellBean;
import com.java.bean.ShellCarParkingBean;
import com.java.bean.ShellCarParkingInfoBean;
import com.java.bean.ShellHistoryBean;

/**
 * 车位购买service
 * @author 罗维
 *
 * 2019年3月25日
 */
public interface IBuyCarParkingMapper {

	

	@Select("<script>"
			+ "select *,priv.state as carState,sel.state as releaseState "
			+ " from sellcars as sel left join privatecars as priv on sel.privatecarsid = priv.privatecarsid "
			+ " left join user as user on user.userid = priv.userid "
			+ " where priv.state = '等待出售' "
			+ "<if test='startPricte != null'>and price &gt;= #{startPricte}</if> "
			+ "<if test='endPricte != null'>and price &lt;= #{endPricte}</if> "
			+ "LIMIT #{pageNum},#{pageSize}"
			+ "</script>")
	/**
	 * 显示所有出售车辆
	 * @param userId 当前登录用户
	 * @param startPricte 开始价格
	 * @param endPricte 结束结构
	 * @param pageNum 当前页
	 * @param pageSize当前页
	 * @return 数据
	 */
	List<ShellCarParkingInfoBean> selectAllSellCar(@Param("userId")Integer userId,
			@Param("startPricte")Integer startPricte,
			@Param("endPricte")Integer endPricte,
			@Param("pageNum")Integer pageNum,
			@Param("pageSize")Integer pageSize);
	
	@Select("<script>"
			+ "select count(1) "
			+ " from sellcars as sel left join privatecars as priv on sel.privatecarsid = priv.privatecarsid "
			+ " left join user as user on user.userid = priv.userid "
			+ " where priv.state = '等待出售' "
			+ "<if test='startPricte != null'>and price &gt;= #{startPricte}</if> "
			+ "<if test='endPricte != null'>and price &lt;= #{endPricte}</if> "
			+ "</script>")
	/**
	 * 查询显示总页数
	 * @param userId 当前登录用户
	 * @param startPricte 开始价格
	 * @param endPricte 结束结构
	 * @return 总页数
	 */
	int selectAllSellCarNum(@Param("userId")Integer userId,
			@Param("startPricte")Integer startPricte,
			@Param("endPricte")Integer endPricte);
	/**
	 * 查询正在购买车位信息
	 * @param userId 当前登录用户
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示多少天
	 * @return 查询结果
	 */
	@Select("select *,priv.state as carState,sell.state as sellState from privatecars as priv join user as user on priv.userid = user.userid join sellcars as sell"
			+ " on sell.privatecarsid = priv.privatecarsid where priv.privatecarsid = #{privatecarsid}")
	ShellCarParkingBean selectAllUserBuyCar(@Param("privatecarsid")Integer userId);
	/**
	 * 根据id查询出售车位用户
	 * @param userId 当前登录用户
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少条
	 * @return 信息
	 */
	@Select("select sellcarsid from purchasecars where userid = #{userId} and state <> '历史记录'limit #{pageNum},#{pageSize} ")
	List<Integer>selectAllUserBuyCarId(@Param("userId")Integer userId,
			@Param("pageNum")Integer pageNum,
			@Param("pageSize")Integer pageSize);
	/**
	 * 查询出手车位数量
	 * @param userId
	 * @return
	 */
	@Select("select count(1) from purchasecars where userid = #{userId} and state <> '历史记录'")
	Integer selectAllUserBuyCarIdNum(@Param("userId")Integer userId);
	
	
	
	/**
	 * 查询所有记录
	 * @param userId 当前登录人
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少条
	 * @return 数据
	 */
	@Select("select priv.privatecarsid from privatecars "
			+ "as priv join user as user on priv.userid = user.userid "
			+ "where user.userid = #{userId} and priv.state "
			+ "in('已经预定','同意出售','等待对方同意') limit #{pageNum},#{pageSize}")
	List<Integer> selectAllBuyUserSellId(@Param("userId")int userId,
	@Param("pageNum")Integer pageNum,
	@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询总条数
	 * @param userId 用户id 
	 * @return 数据
	 */
	@Select("select count(1) from privatecars " + 
			"as priv join user as user on priv.userid = user.userid " + 
			"where user.userid = #{userId} and priv.state " + 
			"in('已经预定','同意出售','等待对方同意')")
	Integer selectAllBuyUserSellIdNum(@Param("userId")int userId);

	/**
	 * 查询出售正在出售车位
	 * @param buyUserId 购买人id
	 * @return 数据
	 */
	@Select("select *,pur.state as buyState, priv.state as carState from purchasecars as pur join user as user "
			+ "on user.userid = pur.userid  join privatecars as priv "
			+ "on priv.privatecarsid = pur.sellcarsid "
			+ "where priv.privatecarsid = #{buyUserId}")
	BuyerInformationBean selectAllUserSellCar(@Param("buyUserId")Integer buyUserId);
	
	
	/**
	 * 根据车位id查询出售合同信息
	 * @param carParkId 车位id
	 * @return 数据
	 */
	@Select("select *,sell.state as sellState from sellcars as sell "
			+ "join user as user on sell.buyuserid = user.userid join privatecars as priv on sell.privatecarsid = priv.privatecarsid "
			+ "where sell.privatecarsid = #{carParkId} and sell.state <> '历史记录'")
	SelectContractShellBean selectContractForShell(@Param("carParkId")int carParkId);
	
	/**
	 * 根据车位id查询出售购买合同信息
	 * @param carParkId 车位id
	 * @return 数据
	 */
	@Select("select *,pur.state as purState from purchasecars as pur join user as user on pur.userid = user.userid join privatecars as priv on pur.sellcarsid = priv.privatecarsid "
			+ "where pur.sellcarsid = #{carParkId} and pur.state <> '历史记录'")
	SelectContractBuyBean selectContractForBuy(@Param("carParkId")int carParkId);
	
	/**
	 * 查询当前用户交易成功的合同
	 * @param userId 当前登录用户
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少条
	 * @return 数据
	 */ 
	@Select("SELECT sellcarsid FROM sellcars where buyuserid = #{userId} and state = '历史记录'  limit #{pageNum},#{pageSize}")
	List<Integer> selectContractSellcarsid(@Param("userId")int userId,
			@Param("pageNum")Integer pageNum,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询用户交易成功的合同数量
	 * @param userId 当前登录用户
	 * @return 数据
	 */
	@Select("SELECT count(1) FROM sellcars where buyuserid = #{userId} and state = '历史记录' ")
	Integer selectContractSellcarsidNum(@Param("userId")int userId);
	
	/**
	 * 查询所有出售历史记录
	 * @param sellcarsid 出售id
	 * @return 数据
	 */
	@Select("select *, pur.state as purState from examine as exa join purchasecars as pur on exa.purchasecarsid = pur.purchasecarsid "
			+ "join privatecars as priv on   pur.sellcarsid = priv.privatecarsid join user as user on pur.userid = user.userid"
			+ " where exa.sellcarsid = #{sellcarsid}")
	ShellHistoryBean selectShellHistory(@Param("sellcarsid")int sellcarsid);
	
	/**
	 * 查询所有购买记录
	 * @param userId 当前登录用户
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少天
	 * @return 数据
	 */
	@Select("select purchasecarsid from purchasecars where state = '历史记录' and userid = #{userId} limit #{pageNum},#{pageSize}")
	List<Integer> selectContractPurchasecarsid(@Param("userId")int userId,
			@Param("pageNum")Integer pageNum,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询所有购买记录条数
	 * @param userId 当前登录用户
	 * @return 数据
	 */
	@Select("select count(1) from purchasecars where state = '历史记录' and userid = #{userId}")
	Integer selectContractPurchasecarsidNum(@Param("userId")int userId);
	
	/**
	 * 查询购买历史记录
	 * @param purchasecarsid 购买id
	 * @return 数据
	 */
	@Select("select *,sell.state as sellState from examine as exa "
			+ "join sellcars as sell on exa.sellcarsid = sell.sellcarsid join user as user on sell.buyuserid = user.userid "
			+ "join privatecars as priv on priv.privatecarsid = sell.privatecarsid"
			+ " where exa.purchasecarsid = #{purchasecarsid}")
	BuyHistoryBean selectBuyHistory(@Param("purchasecarsid")int purchasecarsid);
}
