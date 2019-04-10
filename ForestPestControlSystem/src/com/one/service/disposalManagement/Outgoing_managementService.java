package com.one.service.disposalManagement;

import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Outgoing_managementBean;
import com.one.service.disposalManagement.imp.Outgoing_managementServiceImp;

public interface Outgoing_managementService {

	static Outgoing_managementService getInstance() {
		
		return new Outgoing_managementServiceImp();
	}
	
	/**
	 * 	��ѯ���г����¼
	 * @param map
	 * @return
	 */
	PageBean<Outgoing_managementBean> getShowOutGoing(int pageNum,int pageSize,String dateStrat,String dateEnd);
	/**
	 * 	��ӳ����¼
	 * @param omb
	 * @return
	 */
	Integer addOutGoing(Outgoing_managementBean omb);
	
	Map<String,Object> getAll();
}
