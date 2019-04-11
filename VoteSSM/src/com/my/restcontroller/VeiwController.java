package com.my.restcontroller;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.service.IAdminService;
import com.my.service.IViewService;
import com.my.util.ResponseData;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/jsp/")
@SessionAttributes("admin")
@Log4j
public class VeiwController {

	@Autowired
	private IViewService viewService;
	
	@Autowired
	private IAdminService adminService;
	
	@RequestMapping(value="selectAllPubVote",method=RequestMethod.GET)
	public ResponseData selectAllPubVote() {
		log.log(Priority.DEBUG, "接收到：selectAllPubVote请求");
		ResponseData responseData = new ResponseData();
		responseData.getData().put("votes", viewService.selectAllPubVote());
		return responseData;
		
	}
	
	
	@RequestMapping(value="selectContextById",method=RequestMethod.GET)
	public ResponseData selectContextById(
			@RequestParam("id")int id
			) {
		log.log(Priority.DEBUG, "接收到：selectContextById请求");
		ResponseData responseData = new ResponseData();
		responseData.getData().put("voteContes",adminService.findOneVoteContext(id));
		return responseData;
		
	}
	
	@RequestMapping(value="updateVoteContext",method=RequestMethod.PUT)
	public ResponseData updateVoteContext(
			@RequestParam("id")String id,
			@RequestParam("voteId")int voteId
			) {
		ResponseData responseData = new ResponseData();
		viewService.updateVoteContext(id);
		responseData.getData().put("voteContes",adminService.findOneVoteContext(voteId));
		return responseData;
		
	}
}
