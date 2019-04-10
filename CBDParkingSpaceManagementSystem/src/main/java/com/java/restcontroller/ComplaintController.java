package com.java.restcontroller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.ComplaintBean;
import com.java.entity.Complaint;
import com.java.entity.User;
import com.java.service.ComplaintService;
import com.java.service.UserService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

/**
 * 投诉管理页面控制器
 * @author 刘云升
 *
 * 2019年3月21日
 */
@RestController
public class ComplaintController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ComplaintService complaintService;
	/**
	 * 分页查询所有投诉信息
	 * @param curPage 第几页
	 * @param pageSize 每页显示多少条数据
	 * @return 通用返回数据
	 */
	@RequestMapping("showAllComplaint")
	public ResponseData showAllComplaint(@RequestParam("curPage")int curPage,
			@RequestParam("pageSize")int pageSize) {
		List<ComplaintBean> complaintBeans = new ArrayList<ComplaintBean>();
		Page<Complaint> pageList = complaintService.selectPage(new Page<Complaint>(curPage, pageSize),new EntityWrapper<Complaint>().eq("state", "受理"));
		List<Complaint> list = pageList.getRecords();
		for (Complaint complaint : list) {
			ComplaintBean complaintBean = new ComplaintBean();
			complaintBean.setBUser(userService.selectOne(new EntityWrapper<User>().eq("userid", complaint.getBid())).getName()); 
			complaintBean.setBtUser(userService.selectOne(new EntityWrapper<User>().eq("userid", complaint.getBtid())).getName());
			complaintBean.setComplaintime(complaint.getComplaintime());
			complaintBean.setContent(complaint.getContent());
			complaintBeans.add(complaintBean);
		}
		ResponseData data = new ResponseData();
		data.getData().put("Page", pageList);
		data.getData().put("ComplaintBean", complaintBeans);
		return data;
	}
	/**
	 * 
	 * @param complaintBean 参数绑定bean
	 * @return 通用返回数据
	 */
	@LogStatistics(operatecontent="审核投诉",operation=logType.修改)
	@RequestMapping("updateComplaint")
	public ResponseData updateComplaint(ComplaintBean complaintBean) {
		Complaint complaint = new Complaint();
		complaint.setComplaintid(complaintBean.getComplaintid());
		complaint.setState(complaintBean.getState());
		String state = "已处理";
		if(state.equals(complaintBean.getState())) {
			User user = userService.selectOne(new EntityWrapper<User>().eq("userid", complaintBean.getBtid()));
			user.setComplaintnumber(user.getComplaintnumber()+1);
			userService.update(user, new EntityWrapper<User>().eq("userid", complaintBean.getBtid()));
		}else {
			
			;
		}
		boolean flag = complaintService.update(complaint, new EntityWrapper<Complaint>().eq("complaintid", complaintBean.getComplaintid()));
		if(flag) {
		
			return ResponseData.ok();
			
		}else {
			return ResponseData.noFound();
		}
	}
}
