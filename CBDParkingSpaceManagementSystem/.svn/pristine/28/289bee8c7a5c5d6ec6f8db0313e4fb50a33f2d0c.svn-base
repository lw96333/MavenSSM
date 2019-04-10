package com.java.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.BuyHistoryBean;
import com.java.bean.BuyerInformationBean;
import com.java.bean.PageBean;
import com.java.bean.SelectContractBuyBean;
import com.java.bean.SelectContractShellBean;
import com.java.bean.ShellCarParkingBean;
import com.java.bean.ShellCarParkingInfoBean;
import com.java.bean.ShellHistoryBean;
import com.java.entity.Complaint;
import com.java.entity.Examine;
import com.java.entity.Privatecars;
import com.java.entity.Purchasecars;
import com.java.entity.Sellcars;
import com.java.entity.User;
import com.java.entity.Userbilling;
import com.java.mapper.ComplaintMapper;
import com.java.mapper.ExamineMapper;
import com.java.mapper.IBuyCarParkingMapper;
import com.java.mapper.PrivatecarsMapper;
import com.java.mapper.PurchasecarsMapper;
import com.java.mapper.SellcarsMapper;
import com.java.service.IBuyCarParkingService;
import com.java.service.UserService;
import com.java.service.UserbillingService;

import lombok.extern.log4j.Log4j;

/**
 * 车位购买实现类
 * 
 * @author 罗维
 *
 *         2019年3月25日
 */
@Service
@Log4j
public class BuyCarParkingServiceImpl implements IBuyCarParkingService {

	@Autowired
	private IBuyCarParkingMapper buyCarParkingMapper;
	
	@Autowired
	private PurchasecarsMapper purchasecarsMapper;
	
	@Autowired
	private SellcarsMapper sellcarsMapper;
	
	@Autowired
	private PrivatecarsMapper privatecarsMapper;
	
	@Autowired
	private ExamineMapper examineService;
	
	@Autowired
	private ComplaintMapper complaintMapper;
	
	@Autowired
	private UserbillingService userbillingService;
	
	@Autowired
	private UserService userService;
	
	private final String TYPE_Z = "0";
	
	private final String TYPE_O = "1";
	
	private final String TRANSACTION_COMPLETED = "交易完成";

	private final String AGREED_TO_SELL = "同意出售";
	@Override
	public PageBean<ShellCarParkingInfoBean> selectAllSellCar(Integer userid, Integer startPricte, Integer endPricte,
			Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		
		PageBean<ShellCarParkingInfoBean> page = new PageBean<ShellCarParkingInfoBean>();

		List<ShellCarParkingInfoBean> li = buyCarParkingMapper.selectAllSellCar(userid, startPricte, endPricte,
				(pageNum - 1) * pageSize, pageSize);

		int liTotal = buyCarParkingMapper.selectAllSellCarNum(userid, startPricte, endPricte);
		log.info("条数："+liTotal);
		page.setTotalData(liTotal);
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		page.setTotalNum((int) Math.ceil((double) page.getTotalData() / pageSize));
		page.setPageData(li);

		return page;
	}

	@Override
	public void insertBuyCar(int userId,int carParkId, String message, Integer price) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EntityWrapper entityWrapper = new EntityWrapper<Sellcars>();
		entityWrapper.eq("privatecarsid", carParkId);
		Privatecars privatecars = new Privatecars();
		privatecars.setState("已经预定");
		
		privatecarsMapper.update(privatecars, entityWrapper);
		privatecars.setPrivatecarsid(carParkId);
		Privatecars privatecarsOne = privatecarsMapper.selectOne(privatecars);
		
		
		Purchasecars purchasecars = new Purchasecars();

		purchasecars.setPrice(price+"");
		purchasecars.setSellcarsid(carParkId);
		purchasecars.setStartime(sdf.format(new Date()));
		purchasecars.setState("等待出售人回复");
		purchasecars.setUserid(userId);
		purchasecars.setMessage(message);
		purchasecarsMapper.insert(purchasecars);
		
		Sellcars sellcars = new Sellcars();
		
		sellcars.setState("查看预约");
		sellcars.setMessage(message);
		sellcars.setPrice(price+"");
		sellcars.setBuyuserid(privatecarsOne.getUserid());
		
		sellcarsMapper.update(sellcars, entityWrapper);
		
		
		
	}


	@Override
	public PageBean<ShellCarParkingBean> selectAllUserBuyCar(Integer userId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean<ShellCarParkingBean> page = new PageBean<ShellCarParkingBean>();
		List<ShellCarParkingBean> li = new ArrayList<ShellCarParkingBean>();
		page.setTotalData(buyCarParkingMapper.selectAllUserBuyCarIdNum(userId));
		List<Integer> num = buyCarParkingMapper.selectAllUserBuyCarId(userId, (pageNum-1)*pageSize, pageSize);
		System.out.println(num.size());
		for(int index = 0;index < num.size(); index++) {
			ShellCarParkingBean bib = buyCarParkingMapper.selectAllUserBuyCar(num.get(index));
			li.add(bib);
		}
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		page.setTotalNum((int) Math.ceil((double) page.getTotalData() / pageSize));
		page.setPageData(li);
		return page;
	}

	@Override
	public PageBean<BuyerInformationBean> selectAllUserSellCar(Integer userId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean<BuyerInformationBean> page = new PageBean<BuyerInformationBean>();

		page.setTotalData(buyCarParkingMapper.selectAllBuyUserSellIdNum(userId));
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		page.setTotalNum((int) Math.ceil((double) page.getTotalData() / pageSize));
		List<Integer> num = buyCarParkingMapper.selectAllBuyUserSellId(userId,(pageNum-1)*pageSize,pageSize);
		List<BuyerInformationBean> li = new  ArrayList<BuyerInformationBean>();
		System.out.println(num.size());
		for(int index = 0;index < num.size() ; index++) {
			System.out.println(num.get(index));
			li.add(buyCarParkingMapper.selectAllUserSellCar(num.get(index)));
			
		}
		page.setPageData(li);
		return page;
	}

	@Override
	public void insertShellPark(int carId,int userId) {
		// TODO Auto-generated method stub
		EntityWrapper<Sellcars> entitySellcars = new EntityWrapper<Sellcars>();
		entitySellcars.eq("privatecarsid", carId);
		Sellcars sellcars = new Sellcars();
		sellcars.setPrivatecarsid(carId);

		Sellcars sellcarsOne = sellcarsMapper.selectList(entitySellcars).get(0);
		
		sellcarsOne.setState(AGREED_TO_SELL);
		sellcarsOne.setBuyuserid(userId);
		sellcarsMapper.update(sellcarsOne, entitySellcars);
		EntityWrapper<Privatecars> entityPrivatecars = new EntityWrapper<Privatecars>();
		entityPrivatecars.eq("privatecarsid", carId);
		Privatecars privatecars = new Privatecars();
		privatecars.setPrivatecarsid(carId);
		Privatecars privatecarsOne = privatecarsMapper.selectOne(privatecars);
		privatecarsOne.setState(AGREED_TO_SELL);
		privatecarsMapper.update(privatecarsOne, entityPrivatecars);
		EntityWrapper<Purchasecars> entityPurchasecars = new EntityWrapper<Purchasecars>();
		entityPurchasecars.eq("sellcarsid", carId);
		Purchasecars prPurchasecars = new Purchasecars();
		prPurchasecars.setSellcarsid(carId);
		Purchasecars purchasecarsOne = purchasecarsMapper.selectOne(prPurchasecars);
		purchasecarsOne.setState(AGREED_TO_SELL);
		purchasecarsMapper.update(purchasecarsOne, entityPurchasecars);
	}

	@Override
	public SelectContractShellBean selectContractShell(int carParkId) {
		// TODO Auto-generated method stub
		
		return buyCarParkingMapper.selectContractForShell(carParkId);
	}
	
	
	
	@Override
	public void insertContract(String number, int carParkId, String type) {
		// TODO Auto-generated method stub
		
		Sellcars sellcars = new Sellcars();
		sellcars.setPrivatecarsid(carParkId);
		Sellcars sellcarsOne = sellcarsMapper.selectList(new EntityWrapper<Sellcars>().eq("privatecarsid",carParkId)).get(0);
		Purchasecars purchasecars = new Purchasecars();
		purchasecars.setSellcarsid(carParkId);
		Purchasecars purchasecarsOne = purchasecarsMapper.selectList(new EntityWrapper<Purchasecars>().eq("sellcarsid", carParkId)).get(0);			
		if(this.TYPE_Z.equals(type)) {
			sellcarsOne.setState(TRANSACTION_COMPLETED);
			sellcarsMapper.update(sellcarsOne, new EntityWrapper<Sellcars>().eq("privatecarsid",carParkId));
			if(purchasecarsOne.getState().equals(TRANSACTION_COMPLETED)) {
				saveExamin(number,sellcarsOne,purchasecarsOne,carParkId);
			}else {
				purchasecarsOne.setState("对方已同意");
				purchasecarsMapper.update(purchasecarsOne, new EntityWrapper<Purchasecars>().eq("sellcarsid",carParkId));
			}
		}else if(this.TYPE_O.equals(type)){
			purchasecarsOne.setState(TRANSACTION_COMPLETED);
			purchasecarsMapper.update(purchasecarsOne, new EntityWrapper<Purchasecars>().eq("sellcarsid", carParkId));
			if(sellcarsOne.getState().equals(TRANSACTION_COMPLETED)) {
				saveExamin(number,sellcarsOne,purchasecarsOne,carParkId);
			}else {
				sellcarsOne.setState("对方已同意");
				sellcarsMapper.update(sellcarsOne, new EntityWrapper<Sellcars>().eq("privatecarsid",carParkId));
			}
		}
		
	
		
	}
	
	private void saveExamin(String number,Sellcars sellcars,Purchasecars purchasecars,int carParkId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Examine examine = new Examine();
		String date = sdf.format(new Date());
		examine.setFromdate(date);
		examine.setPrice(purchasecars.getPrice());
		examine.setPurchasecarsid(purchasecars.getPurchasecarsid()+"");
		examine.setSellcarsid(sellcars.getSellcarsid());
		examine.setContractnumber(number);
		
		examineService.insert(examine);
		
		Privatecars privatecars = new Privatecars();
		privatecars.setPrivatecarsid(carParkId);
		Privatecars privatecarsOne = privatecarsMapper.selectOne(privatecars);
//		privatecarsOne.setUserid(purchasecars.getUserid());
		System.out.println("=======================================");
		privatecarsOne.setState("历史记录");
		privatecarsMapper.update(privatecarsOne, new EntityWrapper<Privatecars>().eq("privatecarsid", carParkId));
		
		purchasecars.setState("历史记录");
		purchasecarsMapper.update(purchasecars, new EntityWrapper<Purchasecars>().eq("sellcarsid",carParkId));
		sellcars.setState("历史记录");
		sellcarsMapper.update(sellcars, new EntityWrapper<Sellcars>().eq("privatecarsid",carParkId));
		
		//添加卖家记录
		Userbilling sellUser = new Userbilling();
		sellUser.setStarttime(sellcars.getIssuetime());
		sellUser.setEndtime(date);
		sellUser.setIncome(Double.parseDouble(sellcars.getPrice()));
		sellUser.setUserid(sellcars.getBuyuserid());
		userbillingService.insert(sellUser);
		
		//添加买家记录
		Userbilling buyUser = new Userbilling();
		buyUser.setStarttime(sellcars.getIssuetime());
		buyUser.setEndtime(date);
		buyUser.setExpend(Double.parseDouble(sellcars.getPrice()));
		buyUser.setUserid(purchasecars.getUserid());
		userbillingService.insert(buyUser);
		
		
		User userSell = userService.selectOne(
					new EntityWrapper<User>()
					.eq("userid", sellcars.getBuyuserid()));
		userSell.setDealnumber(userSell.getDealnumber()+1);
		userService.update(userSell, new EntityWrapper<User>().eq("userid", sellcars.getBuyuserid()));
		
		
		User userBuy = userService.selectOne(
					new EntityWrapper<User>()
					.eq("userid",purchasecars.getUserid()));
		userBuy.setDealnumber(userBuy.getDealnumber()+1);
		userService.update(userBuy, new EntityWrapper<User>().eq("userid", purchasecars.getUserid()));
		
	}

	@Override
	public PageBean<ShellHistoryBean> shellHistory(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		log.info("进入查询出售历史记录");
		log.info("用户id"+userId);
		List<Integer> num  = buyCarParkingMapper.selectContractSellcarsid(userId, (pageNum-1)*pageSize, pageSize);
		int totalNum = buyCarParkingMapper.selectContractSellcarsidNum(userId);
		List<ShellHistoryBean> li = new ArrayList<ShellHistoryBean>();
		PageBean<ShellHistoryBean> page = new PageBean<ShellHistoryBean>();
		log.info("查询记录条数："+totalNum);
		page.setTotalData(totalNum);
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		page.setTotalNum((int) Math.ceil((double) page.getTotalData() / pageSize));
	

		for(int index = 0;index < num.size() ; index++) {
			System.out.println(num.get(index));
			li.add(buyCarParkingMapper.selectShellHistory(num.get(index)));
			
		}
		page.setPageData(li);
		
		return page;
		
		
	}

	@Override
	public PageBean<BuyHistoryBean> buyHistory(int userId, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Integer> num  = buyCarParkingMapper.selectContractPurchasecarsid(userId, (pageNum-1)*pageSize, pageSize);
		int totalNum = buyCarParkingMapper.selectContractPurchasecarsidNum(userId);
		List<BuyHistoryBean> li = new ArrayList<BuyHistoryBean>();
		PageBean<BuyHistoryBean> page = new PageBean<BuyHistoryBean>();

		page.setTotalData(totalNum);
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		page.setTotalNum((int) Math.ceil((double) page.getTotalData() / pageSize));
	

		for(int index = 0;index < num.size() ; index++) {
			System.out.println(num.get(index));
			li.add(buyCarParkingMapper.selectBuyHistory(num.get(index)));
			
		}
		page.setPageData(li);
		
		return page;
	}

	@Override
	public void complaint(int userId, int beComPlainedId, String reason) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Complaint complaint = new Complaint();
		complaint.setBid(userId);
		complaint.setBtid(beComPlainedId);
		complaint.setComplaintime(sdf.format(new Date()));
		complaint.setContent(reason);
		complaint.setState("待审核");
		complaintMapper.insert(complaint);
	}

	@Override
	public SelectContractBuyBean selectContractBuy(int carParkId) {
		// TODO Auto-generated method stub
		return buyCarParkingMapper.selectContractForBuy(carParkId);
	}

	@Override
	public void cancellationOfContract(int carId) {
		// TODO Auto-generated method stub
	
		
		sellcarsMapper.delete(
				new EntityWrapper<Sellcars>()
				.eq("sellcarsid", carId));
		purchasecarsMapper.delete(
				new EntityWrapper<Purchasecars>()
				.eq("sellcarsid", carId));
		Privatecars privatecars = new Privatecars();
		privatecars.setPrivatecarsid(carId);
		Privatecars privatecarsOne = privatecarsMapper.selectOne(privatecars);
		privatecarsOne.setState("等待出售");
		privatecarsMapper.update(privatecarsOne, new EntityWrapper<Privatecars>().eq("privatecarsid", carId));
	}

	
	
}
