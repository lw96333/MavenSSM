package com.one.dao.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.disposalManagement.Consultation_managementBean;

   public interface Consultation_managementDao {

	/**
	 *     添加器械
	 * @param consultation_managementBean
	 * @return
	 */
	public Integer add_instruments(Consultation_managementBean consultation_managementBean);
	/**
	 *   查询器械信息
	 * @param map
	 * @return
	 */
	public List<Consultation_managementBean> getAllConsultation_management(Map<String,Object> map);
	/**
	 * 	根据条件查询
	 * @param map
	 * @return
	 */
	int  getAllConsultation_managementNum(Map<String,Object> map);
}
