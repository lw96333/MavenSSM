package com.one.service.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;

public interface SmallClassService {
	/**
	 * 
	 * @return 查询所有小班
	 */
	public PageBean<List<SmallClassManagementBean>> getAllSmallClassManagement(int pageNum, int pageSize, String smallClassName,
			String areaName);
	/**
	 * 
	 * @return 查询所有小班
	 */
	public List<SmallClassManagementBean> getAllSmallClassManagementByName();
	/**
	 * 添加小班
	 * @param smallClass 小班
	 * @return 是否添加成功
	 */
	public int addSmallClass(SmallClassManagementBean smallClass);
	/**
	 * 查看小班信息
	 * @param id 小班ID
	 * @return 小班信息
	 */
	public SmallClassManagementBean getSmallClassInfoById(int id);
	/**
	 * 修改小班信息
	 * @param  small 小班
	 * @return 是否修改成功
	 */
	public int updateSmallClassById(SmallClassManagementBean small);
}
