package com.my.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.bean.AdminBean;
import com.my.bean.VoteContextBean;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;
import com.my.service.IAdminService;
import com.my.util.ResponseData;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/jsp/")
@SessionAttributes("admin")
@Log4j
public class AdminController {
	
	@Autowired
	private IAdminService adminService;

	@RequestMapping(value="login",method=RequestMethod.GET)
	public ResponseData login(AdminBean adminBean,ModelMap modelMap) {
		log.log(Priority.DEBUG, "接受到：login请求");
		log.log(Priority.DEBUG, adminBean);
		AdminEntity adminEntity = adminService.findAdminByNameAndPassword(adminBean);
		
		ResponseData responseData = new ResponseData();
		if(adminEntity == null) {
			responseData.setCode(400);
			responseData.setMessage("error");
			return responseData;
		}
		modelMap.addAttribute("admin", adminEntity);
		adminService.updateLoginTimeById(adminEntity.getAdmin_id());
		
		return responseData;
	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ResponseData displayIndex(ModelMap modelMap) {
		log.log(Priority.DEBUG, "接受到：index请求");
		ResponseData responseData = new ResponseData();
		AdminEntity adminEntity = (AdminEntity) modelMap.get("admin");
		List<VoteEntity> votes = adminService.findVoteById(adminEntity.getAdmin_id());
		responseData.getData().put("votes", votes);
		return responseData;
	}
	
	@RequestMapping(value="voteDisplay",method=RequestMethod.GET)
	public ResponseData displayVote(ModelMap modelMap){
		log.log(Priority.DEBUG, "接受到：voteDisplay请求");
		ResponseData responseData = new ResponseData();
		AdminEntity adminEntity = (AdminEntity) modelMap.get("admin");
		List<VoteEntity> votes = adminService.findAllVoteById(adminEntity.getAdmin_id());
		responseData.getData().put("votes", votes);
		return responseData;
	}
	
	@RequestMapping(value="voteContextDisplay",method=RequestMethod.GET)
	public ResponseData displayContext(@RequestParam("id")int id,ModelMap modelMap) {
		log.log(Priority.DEBUG, "接受到：voteContextDisplay请求");
		ResponseData responseData = new ResponseData();
		List<VoteContextEntity> voteContextEntities = adminService.findOneVoteContext(id);
		responseData.getData().put("voteContext", voteContextEntities);
		return responseData;
	}
	
	@RequestMapping(value="voteContextUpdate",method=RequestMethod.POST)
	public ResponseData updateVoteContext(VoteContextBean voteContextBean) {
		log.log(Priority.DEBUG, "接受到：voteContextUpdate请求");
		adminService.updateVoteContext(voteContextBean);
		
		return ResponseData.ok();
	}
	@RequestMapping(value="addvoteAndContext",method=RequestMethod.PUT)
	public ResponseData addVoteAndContext(VoteContextBean voteContextBean,ModelMap modelMap) {
		log.log(Priority.DEBUG, "接受到：addvoteAndContext请求");
		log.log(Priority.DEBUG, voteContextBean);
		AdminEntity adminEntity = (AdminEntity) modelMap.get("admin");
		adminService.addVoteAndContext(voteContextBean, adminEntity.getAdmin_id());
		return ResponseData.ok();
	}
	
	@RequestMapping(value="voteDisplayByCondition",method=RequestMethod.GET)
	public ResponseData voteDisplayByCondition(
				@RequestParam("condition")String condition,
				ModelMap modelMap
			) {
		log.log(Priority.DEBUG, "接受到：voteDisplayByCondition请求");
		ResponseData responseData = new ResponseData();
		AdminEntity adminEntity = (AdminEntity) modelMap.get("admin");
		List<VoteEntity> li = adminService.findAllVoteByIdAndCondition(adminEntity.getAdmin_id(), condition);
		
		responseData.getData().put("votes", li);
		return responseData;
	}
	
	@RequestMapping(value="updateAccountPwd",method=RequestMethod.POST)
	public ResponseData updateAccountPwd(
			@RequestParam("pwd")String pwd,
			ModelMap modelMap
			) {
		log.log(Priority.DEBUG, "接受到：updateAccountPwd请求");
		log.log(Priority.DEBUG, "pwd："+pwd);
		AdminEntity adminEntity = (AdminEntity) modelMap.get("admin");
		adminService.updateAccountPwd(adminEntity.getAdmin_id(), pwd);
		modelMap.remove("admin");
		return ResponseData.ok();
	}
	
	@RequestMapping(value="insertAccountPwd",method=RequestMethod.POST)
	public ResponseData insertAccountPwd(
			@RequestParam("account")String account,
			@RequestParam("pwd")String pwd,
			ModelMap modelMap
			) {
		log.log(Priority.DEBUG, "接受到：insertAccountPwd请求");
		log.log(Priority.DEBUG, "pwd："+pwd+":account："+account);
		adminService.insertAccount(account, pwd);	
		modelMap.remove("admin");
		
		return ResponseData.ok();
	}
	
	@RequestMapping(value="end",method=RequestMethod.GET)
	public ResponseData end(
			ModelMap modelMap
			) {
		log.log(Priority.DEBUG, "end");
		modelMap.remove("admin");
		
		return ResponseData.ok();
	}
	
}
