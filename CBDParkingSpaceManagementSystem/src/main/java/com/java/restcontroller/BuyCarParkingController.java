package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.BuyerInformationBean;
import com.java.bean.PageBean;
import com.java.bean.SelectContractBuyBean;
import com.java.bean.SelectContractShellBean;
import com.java.bean.ShellCarParkingBean;
import com.java.bean.ShellCarParkingInfoBean;
import com.java.entity.User;
import com.java.service.IBuyCarParkingService;
import com.java.util.ResponseData;

/**
 * 买卖车位控制器
 * 
 * @author 罗维
 *
 *         2019年3月25日
 */
@RestController
public class BuyCarParkingController {

	@Autowired
	private IBuyCarParkingService buyCarParkingController;


	/**
	 * 显示所有出售车辆
	 * 
	 * @param startPricte 开始价格
	 * @param endPricte   结束结构
	 * @param pageNum     当前页
	 * @param pageSize    每页多少条
	 * @return 数据
	 */
	@RequestMapping("selectAllSellCar")
	public ResponseData selectAllSellCar(Integer startPricte, Integer endPricte, Integer pageNum, Integer pageSize,
			HttpSession session) {
		ResponseData responseData = new ResponseData();
//		User user = (User) session.getAttribute("user");
		PageBean<ShellCarParkingInfoBean> pb = buyCarParkingController.selectAllSellCar(1, startPricte,
				endPricte, pageNum, pageSize);

		responseData.getData().put("allSellCar", pb);
		return responseData;
	}

	/**
	 * 预定车位
	 * 
	 * @param carParkId 车位id
	 * @param message   留言
	 * @param price     价格
	 * @return 信息
	 */
	@RequestMapping("insertBuyCar")
	public ResponseData insertBuyCar(int carParkId, String message, Integer price, HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		buyCarParkingController.insertBuyCar(user.getUserid(), carParkId, message, price);
		return responseData;
	}
	/**
	 * 查询所有个人购买车位信息
	 * @param pageNum当前页
	 * @param pageSize每页多少条
	 * @return 信息
	 */
	@RequestMapping("selectAllBuyPark")
	public ResponseData selectAllBuyPark(int pageNum,int pageSize,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		PageBean<ShellCarParkingBean> pb = buyCarParkingController.selectAllUserBuyCar(user.getUserid(), pageNum, pageSize);
		responseData.getData().put("allSellCar", pb);
		return responseData;
	}
	/**
	 * 查询所有个人出售车位信息
	 * @param pageNum 当前页
	 * @param pageSize 每页多少条
	 * @return 信息
	 */
	@RequestMapping("selectAllShellPark")
	public ResponseData selectAllShellPark(int pageNum,int pageSize,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		PageBean<BuyerInformationBean> pb = buyCarParkingController.selectAllUserSellCar(user.getUserid(), pageNum, pageSize);
		responseData.getData().put("allSellCar", pb);
		return responseData;
	}
	/**
	 * 同意出售车位
	 * @param carParkId
	 * @return
	 */
	@RequestMapping("insertShellPark")
	public ResponseData insertShellPark(int carParkId,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		buyCarParkingController.insertShellPark(carParkId,user.getUserid());
		return responseData;
		
	}
	/**
	 * 查看伙同
	 * @param carParkId 车位id
	 * @return 信息
	 */
	@RequestMapping("selectContract")
	public ResponseData selectContract(int carParkId,HttpSession session) {
		ResponseData responseData = new ResponseData();
		SelectContractShellBean shell = buyCarParkingController.selectContractShell(carParkId);
		responseData.getData().put("shell", shell);
		SelectContractBuyBean buy = buyCarParkingController.selectContractBuy(carParkId);
		responseData.getData().put("buy", buy);
		return responseData;
	}
	/**
	 * 签约
	 * @param number 合同编号
	 * @param carParkId 车位id
	 * @param type 判断买卖（0是卖，1是买）
	 * @return 信息
	 */
	@RequestMapping("insertContractNumber")
	public ResponseData insertContract(String number,int carParkId,String type) {
		ResponseData responseData = new ResponseData();
		buyCarParkingController.insertContract(number, carParkId, type);
		return responseData;
	}
	/**
	 * 查看卖出车位历史记录
	 * @param pageNum 当前页
	 * @param pageSize 每页多少条
	 * @return 信息
	 */
	@RequestMapping("shellHistory")
	public ResponseData shellHistory(int pageNum,int pageSize,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		PageBean pb = buyCarParkingController.shellHistory(user.getUserid(), pageNum, pageSize);
		responseData.getData().put("shellHistory", pb);
		return responseData;
	}
	
	/**
	 * 查看购买车位历史记录
	 * @param pageNum 当前页
	 * @param pageSize 每页多少条
	 * @return 信息
	 */
	@RequestMapping("buyHistory")
	public ResponseData buyHistory(int pageNum,int pageSize,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		PageBean pb = buyCarParkingController.buyHistory(user.getUserid(), pageNum, pageSize);
		responseData.getData().put("buyHistory", pb);
		return responseData;
	}

	/**
	 * 投诉
	 * @param beComPlainedId 被投诉id
	 * @param reason 投诉理由
	 * @return 数据
	 */
	@RequestMapping("complain")
	public ResponseData complaint(int beComPlainedId,String reason,HttpSession session) {
		ResponseData responseData = new ResponseData();
		User user = (User) session.getAttribute("user");
		buyCarParkingController.complaint(user.getUserid(), beComPlainedId, reason);
		return responseData;
	}
	/**
	 * 取消交易
	 * @return
	 */
	@RequestMapping("CancellationOfContract")
	public ResponseData cancellationOfContract(int carId) {
		ResponseData responseData = new ResponseData();
		buyCarParkingController.cancellationOfContract(carId);
		return responseData;
	}
}
