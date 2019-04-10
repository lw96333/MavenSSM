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
	 * 	��ѯ���г����¼
	 * @param map
	 * @return
	 */
	List<Outgoing_managementBean> getAllOutGoing(Map map);
	/**
	 * 	��ѯ��������
	 * @return
	 */
	int getAllOutGoingForNumber(Map map);
	/**
	 * 	��ѯ���г溦
	 * @return
	 */
	List<PestTypesBean> getAllPestTypesBean();
	/**
	 * 	��ѯ��������
	 * @return
	 */
	List<TypeBean> getAllTypeBean();
	/**
	 * 	��ѯС��
	 * @return
	 */
	List<SmallClassManagementBean> getAllSmallClassManagementBean();
	/**
	 * 	��ѯ��Ʒ
	 * @return
	 */
	List<NameOfGoodsBean> getAllNameOfGoodsBean();
	/**
	 * 	���ӳ����¼
	 * @param omb
	 * @return
	 */
	Integer addOutGoing(Outgoing_managementBean omb);
	
}