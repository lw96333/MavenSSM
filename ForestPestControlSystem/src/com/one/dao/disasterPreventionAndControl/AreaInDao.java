package com.one.dao.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.disasterPreventionAndControl.AreaInBean;

/**
 * ����һ��Dao
 * @author 16968
 *
 */
public interface AreaInDao {

	/**
	 * 
	 * @return ��������
	 */
	public List<AreaInBean> getAllAreaIn(Map<String,Object> info);
	/**
	 * 
	 * @return ������������
	 */
	public List<AreaInBean> getAllAreaInByName();
	/**
	 * 
	 * @param areaInBean �������
	 * @return �Ƿ����ӳɹ�
	 */
	public int addAreaIn(AreaInBean areaInBean);
	
	public List<AreaInBean> getAreaInBySmall();
}