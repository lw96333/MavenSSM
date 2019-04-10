package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.config.WebSocketServer;
import com.java.entity.Privatecars;
import com.java.entity.User;
import com.java.service.PrivatecarsService;

import lombok.extern.log4j.Log4j;

/**
 * inf0信息 0出售车位功能订购，1为出售车位订购后对方同意，2出售车位购买方同意合同
 * ，3为出售方同意合同，4为租赁车位订购，5,为出租方同意出租
 * 车位出售和租赁自定义消息推送页面控制器
 * @author 刘云升
 *
 * 2019年3月27日
 */
@RestController
@Log4j
public class ParkingBuyAndSellMessagePushController {
	@Autowired
	private WebSocketServer webSocketServer;
	
	@Autowired
	private PrivatecarsService  privatecarsService;
	
	/**
	 * 预订车位消息推送
	 * @param carid 预订车位id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="pookingPush",method=RequestMethod.POST)
	public void bookingPush(int carid,HttpSession session) {
		log.info("收到pookingPush请求："+carid);
		Privatecars privatecars = privatecarsService.selectList(new EntityWrapper<Privatecars>().eq("privatecarsid",carid)).get(0);
		int touserId = privatecars.getUserid();
		User user = (User) session.getAttribute("user");
		String str = "&0&你的车位"+privatecars.getAreaid()+"已经被"+user.getRealname()+"预订|"+touserId;
		webSocketServer.sendToUser(str);
	}
	
	/**
	 * 出售人同意出售推送
	 * @param purChaserId 购买人id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="agreedToSellPush",method=RequestMethod.POST)
	public void agreedToSellPush(int purChaserId,HttpSession session) {
		log.info("收到agreedToSellPush请求："+purChaserId);
		User user = (User) session.getAttribute("user");
		String str = "&1&你购买的车位"+user.getRealname()+"已经同意出售|"+purChaserId;
		webSocketServer.sendToUser(str);
	}
	/**
	 * 出售人同意合同推送
	 * @param purChaserId 购买人id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="sellConsentContractPush",method=RequestMethod.POST)
	public void sellConsentContractPush(int purChaserId,HttpSession session) {
		log.info("收到consentContractPush请求："+purChaserId); 
		User user = (User) session.getAttribute("user");
		String str = "&3&"+user.getRealname()+"已经签约完合同等待您签约合同|"+purChaserId;
		webSocketServer.sendToUser(str);
	}
	/**
	 * 购买人同意合同推送
	 * @param sellerId 购买人id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="buyConsentContractPush",method=RequestMethod.POST)
	public void buyConsentContractPush(int sellerId,HttpSession session) {
		log.info("收到buyConsentContractPush请求："+sellerId); 
		User user = (User) session.getAttribute("user");
		String str = "&2&"+user.getRealname()+"已经签约完合同等待您签约合同|"+sellerId;
		webSocketServer.sendToUser(str);
	}
	
	/**
	 * 租赁预订车位消息推送
	 * @param carid 预订车位id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="leasePush",method=RequestMethod.POST)
	public void leasePush(int carid,HttpSession session) {
		log.info("收到leasePush请求："+carid);
		Privatecars privatecars = privatecarsService.selectList(new EntityWrapper<Privatecars>().eq("privatecarsid",carid)).get(0);
		int touserId = privatecars.getUserid();
		User user = (User) session.getAttribute("user");
		String str = "&4&你的车位"+privatecars.getAreaid()+"已经被"+user.getRealname()+"预订|"+touserId;
		webSocketServer.sendToUser(str);
	}
	
	/**
	 * 出租人同意出租推送
	 * @param purChaserId 购买人id
	 * @param session 获取自己的数据名称
	 */
	@RequestMapping(value="rentPush",method=RequestMethod.POST)
	public void rentPush(int purChaserId,HttpSession session) {
		log.info("收到rentPush请求："+purChaserId);
		User user = (User) session.getAttribute("user");
		String str = "&5&你租赁的车位"+user.getRealname()+"已经同意出租|"+purChaserId;
		webSocketServer.sendToUser(str);
	}
	
	/**
	 * 出售人查看预订人信息不同意出售
	 * @param purChaserId
	 * @param session
	 */
	@RequestMapping(value="noAgreedPush",method=RequestMethod.POST)
	public void noAgreedPush(int purChaserId,HttpSession session) {
		log.info("收到noAgreedPush请求："+purChaserId);
		User user = (User) session.getAttribute("user");
		String str = "&8&你购买的车位"+user.getRealname()+"不同意您的订购，请你重新购买|"+purChaserId;
		webSocketServer.sendToUser(str);
		
	}
	
	/**
	 * 不同意合同推送
	 * @param userid 对方id
	 * @param session 自己信息
	 */
	@RequestMapping(value="noConsentContractPush",method=RequestMethod.POST)
	public void noConsentContractPush(int userid,HttpSession session) {
		log.info("收到noConsentContractPush请求,对方id:"+userid);
		User user = (User) session.getAttribute("user");
		String str = "&9&网上合同"+user.getRealname()+"不同意签约交易终止|"+userid;
		webSocketServer.sendToUser(str);
		
	}
	
	/**
	 * 后台发送合同推送
	 * @param guserid 购买人id
	 * @param cuserid 出售人id
	 * 
	 */
	@RequestMapping(value="ContractPush",method=RequestMethod.POST)
	public void contractPush(int guserid,int cuserid) {
		log.info("收到ContractPush请求："+"购买人id"+guserid+"出售人id"+cuserid);
		String strg = "&7&您的的请求已同意合同已下发|"+guserid;
		String strc = "&10&您的的请求已同意合同已下发|"+cuserid;
		webSocketServer.sendToUser(strg);
		webSocketServer.sendToUser(strc);
	}
	
	/**
	 * 投诉推送
	 * @param btuserid 被投诉人id
	 * @param session
	 */
	@RequestMapping(value="complaintPush",method=RequestMethod.POST)
	public void complaintPush(int btuserid,HttpSession session) {
		log.info("收到complaintPush请求："+btuserid);
		User user = (User) session.getAttribute("user");
		String str = "&6&你已被"+user.getRealname()+"投诉|"+btuserid;
		webSocketServer.sendToUser(str);
	}
	
	/**
	 * 后台不发送合同交易终止推送
	 * @param guserid 购买人id
	 * @param cuserid 出售人id
	 * 
	 */
	@RequestMapping(value="noContractPush",method=RequestMethod.POST)
	public void noContractPush(int guserid,int cuserid) {
		log.info("收到ContractPush请求："+"购买人id"+guserid+"出售人id"+cuserid);
		String strg = "&7&您的的请求合同后台不通过交易终止|"+guserid;
		String strc = "&10&您的的请求合同后台不通过交易终止|"+cuserid;
		webSocketServer.sendToUser(strg);
		webSocketServer.sendToUser(strc);
	}
	
}
