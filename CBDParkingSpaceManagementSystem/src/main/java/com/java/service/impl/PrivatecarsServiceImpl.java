package com.java.service.impl;

import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.bean.PersonalAddedParkingBean;
import com.java.entity.Privatecars;
import com.java.mapper.PrivatecarsMapper;
import com.java.service.PrivatecarsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 私人车位 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class PrivatecarsServiceImpl extends ServiceImpl<PrivatecarsMapper, Privatecars> implements PrivatecarsService {

	@Autowired
	private PrivatecarsMapper privatecarsMapper;
	
	@Override
	public PageBean<ParkingAreaHomePageBean> getAllPageBean(int pageNum, String endTime, String stateTime) {
		// TODO Auto-generated method stub
		PageBean<ParkingAreaHomePageBean> pageBean = new PageBean<ParkingAreaHomePageBean>();
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put("pageNum", (pageNum - 1) * 4);
		if("".equals(stateTime)) {
			map.put("stateTime", null);
		} else {
			map.put("stateTime", stateTime);
		}
		if("".equals(endTime)) {
			map.put("endTime", null);
		} else {
			map.put("endTime", endTime);
		}
		pageBean.setPageData(privatecarsMapper.getAllParkingInfo(map));
		pageBean.setTotalData(privatecarsMapper.getAll(map).size());
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/4));
		return pageBean;
	}

	@Override
	public ParkingAreaHomePageBean getParkingInfoById(int id) {
		// TODO Auto-generated method stub
		ParkingAreaHomePageBean parkingBean = privatecarsMapper.getParkingById(id);
		return parkingBean;
	}
	
}
