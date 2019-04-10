package com.one.service.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;

public interface AreaInService {

	/**
	 * 
	 * @return ��������
	 */
	public PageBean<List<AreaInBean>> getAllAreaIn(int pageNum, int pageSize, String forest,
			String advantage);
	/**
	 * 
	 * @param areaInBean �������
	 * @return �Ƿ����ӳɹ�
	 */
	public int addAreaIn(AreaInBean areaInBean);
	
	public List<AreaInBean> getAreaInBySmall();
	
	public List<AreaInBean> getAreaInByName();
}