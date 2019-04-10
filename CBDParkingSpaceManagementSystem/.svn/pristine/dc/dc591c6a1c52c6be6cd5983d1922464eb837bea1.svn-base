package com.java.restcontroller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.java.config.WebSocketServer;
import com.java.entity.Online;
import com.java.service.OnlineService;

import lombok.extern.log4j.Log4j;

/**
 * 定时器
 * @author 肖中华
 *
 * 2019年3月28日
 */
@Component
@Log4j
public class TimerController {
	
	@Autowired
	private OnlineService onlineService;
	
	@Scheduled(cron="0 0/30 * * * ?")
	public void reportCurrent() {
		Integer num = WebSocketServer.getWebSocketSet().keySet().size();
		LocalDateTime localDateTime =LocalDateTime.now();
		String time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Online online = new Online();
		online.setTime(time);
		online.setOnlinenumber(Integer.toString(num));
		log.info("当前时间为:" +time +"在线人数"+num);
		onlineService.insert(online);
		
	}
}
