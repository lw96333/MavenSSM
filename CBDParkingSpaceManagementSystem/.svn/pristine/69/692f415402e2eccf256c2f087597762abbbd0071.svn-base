package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.config.WebSocketServer;
import com.java.util.ResponseData;

import lombok.extern.log4j.Log4j;
/**
 * WebSocketServer测试页面控制器
 * @author 刘云升
 *
 * 2019年3月23日
 */
@RestController
@Log4j
public class WebSocketServerTestController {
	@Autowired
	private WebSocketServer webSocketServer;
	
	 @RequestMapping(value="pushVideoListToWeb",method=RequestMethod.POST)
	 public ResponseData pushVideoListToWeb(String userno,String usernoto) {
		 log.info("接受pushVideoListToWeb请求"+"发送人："+userno+"接收人："+usernoto);
		 log.info("当前在线人数"+WebSocketServer.getWebSocketSet().keySet());
		 String str1 = "obj(数据库需要查的信息)";
		 String str = "你的车位"+str1+"已经被"+userno+"预订,点击查看|"+usernoto;
		 //webSocketServer.sendToUser("当前在线人数"+WebSocketServer.getWebSocketSet().keySet());
		 ResponseData responseData = new ResponseData();
		 responseData.getData().put("number", WebSocketServer.getWebSocketSet().keySet());
		 return responseData;
	 }
	 @RequestMapping(value="pushVideoListToWeb1",method=RequestMethod.GET)
	 public ResponseData addSeesion(HttpSession session) {
		 
		 session.setAttribute("userinfo", "id"+session.getId());
		 log.info("接受pushVideoListToWeb1请求"+session.getId());
		 
		 return ResponseData.ok();
	 }
	 
}
