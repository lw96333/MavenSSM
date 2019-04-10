package com.one.dao.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.disposalManagement.Pharmacy_managementBean;

public interface Pharmacy_managementDao {

	/**
	 *   添加药剂
	 * @param pmt
	 * @return
	 */
	public Integer additive(Pharmacy_managementBean pmt);
	/**
	 *   查询药剂信息
	 * @param map
	 * @return
	 */
	public List<Pharmacy_managementBean> getAllPharmacy_management(Map<String,Object> map);
}
