package com.java.service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.bean.BuyHistoryBean;
import com.java.bean.BuyerInformationBean;
import com.java.bean.PageBean;
import com.java.bean.SelectContractBean;
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

public interface IBuyCarParkingService {

	/**
	 * 显示所有出售车辆
	 * @param userid 当前登录用户id
	 * @param startPricte 开始价格
	 * @param endPricte 结束结构
	 * @param pageNum 当前页
	 * @param pageSize 每页多少条
	 * @return 数据
	 */
	PageBean<ShellCarParkingInfoBean> selectAllSellCar(Integer userid,
			Integer startPricte,
			Integer endPricte,
			Integer pageNum,
			Integer pageSize);
	
	/**
	 * 预定车位
	 * @param userId 购买人id
	 * @param carParkId 车辆id
	 * @param message 留言
	 * @param price 价格
	 */
	void insertBuyCar(int userId,int carParkId,String message,Integer price);
	
	
	/**
	 * 查询正在购买车位信息
	 * @param userId 当前登录用户
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示多少天
	 * @return 查询结果
	 */
	PageBean<ShellCarParkingBean> selectAllUserBuyCar(Integer userId,
			Integer pageNum,
			Integer pageSize);
	
	/**
	 * 查询出售正在出售车位
	 * @param userId 当前登录用户id
	 * @param pageNum 当前页
	 * @param pageSize 每页显示多少条
	 * @return 数据
	 */
	PageBean<BuyerInformationBean> selectAllUserSellCar(Integer userId,
			Integer pageNum,
			Integer pageSize);
	/**
	 * 卖家同意更改状态
	 * @param carId 车位id
	 * @param userId 用户id
	 */
	void insertShellPark(int carId,int userId);
	
	/**
	 * 根据车位id查询合同信息出售
	 * @param carParkId 车位id
	 * @return 数据
	 */
	SelectContractShellBean selectContractShell(int carParkId);
	
	/**
	 * 根据车位id查询合同信息购买
	 * @param carParkId 车位id
	 * @return 数据
	 */
	SelectContractBuyBean selectContractBuy(int carParkId);
	
	/**
	 * 添加合同
	 * @param number 合同编号
	 * @param carParkId 车辆id
	 * @param type 买卖类型
	 */
	void insertContract(String number,int carParkId,String type);
	
	/**
	 * 查询出售历史合同
	 * @param userId 当前用户
	 * @param pageNum 当前页
	 * @param pageSize 每页显示数据
	 * @return 数据
	 */
	PageBean<ShellHistoryBean> shellHistory(int userId,int pageNum,int pageSize);
	
	/**
	 * 查询购买历史合同
	 * @param userId 当前用户
	 * @param pageNum 当前页
	 * @param pageSize 每页显示数据
	 * @return 数据
	 */
	PageBean<BuyHistoryBean> buyHistory(int userId,int pageNum,int pageSize);
	
	/**
	 * 投诉
	 * @param userId 投诉人
	 * @param beComPlainedId 被投诉人
	 * @param reason 理由
	 */
	void complaint(int userId,int beComPlainedId,String reason);
	
	/**
	 * 取消交易方法
	 * @param carId 车位id
	 */
	void cancellationOfContract(int carId);
}
