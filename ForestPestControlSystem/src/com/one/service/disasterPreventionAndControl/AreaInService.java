package com.one.service.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;

public interface AreaInService {

	/**
	 * 
	 * @return 所有区域
	 */
	public PageBean<List<AreaInBean>> getAllAreaIn(int pageNum, int pageSize, String forest,
			String advantage);
	/**
	 * 
	 * @param areaInBean 区域对象
	 * @return 是否添加成功
	 */
	public int addAreaIn(AreaInBean areaInBean);
	
	public List<AreaInBean> getAreaInBySmall();
	
	public List<AreaInBean> getAreaInByName();
}
