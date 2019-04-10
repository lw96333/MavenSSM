package com.one.dao.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.NameOfGoodsBean;
import com.one.bean.PestTypesBean;
import com.one.bean.TypeBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.bean.disposalManagement.Outgoing_managementBean;

public interface Outgoing_managementDao {
	/**
	 * 	查询所有出库记录
	 * @param map
	 * @return
	 */
	List<Outgoing_managementBean> getAllOutGoing(Map map);
	/**
	 * 	查询所有数量
	 * @return
	 */
	int getAllOutGoingForNumber(Map map);
	/**
	 * 	查询所有虫害
	 * @return
	 */
	List<PestTypesBean> getAllPestTypesBean();
	/**
	 * 	查询所有类型
	 * @return
	 */
	List<TypeBean> getAllTypeBean();
	/**
	 * 	查询小班
	 * @return
	 */
	List<SmallClassManagementBean> getAllSmallClassManagementBean();
	/**
	 * 	查询物品
	 * @return
	 */
	List<NameOfGoodsBean> getAllNameOfGoodsBean();
	/**
	 * 	添加出库记录
	 * @param omb
	 * @return
	 */
	Integer addOutGoing(Outgoing_managementBean omb);
	
}
