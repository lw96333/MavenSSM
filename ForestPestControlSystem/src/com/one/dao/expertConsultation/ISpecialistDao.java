package com.one.dao.expertConsultation;

import java.util.List;
import java.util.Map;

import com.one.bean.CompanyBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
/**
 * 	专家一览Dao
 * @author 49160
 *
 */
public interface ISpecialistDao {
	/**
	 * 	添加专家
	 * @param specialist
	 * @return
	 */
	int addSpecialist(SpecialistManagementBean specialist);
	/**
	 * 	根据ID查询专家
	 * @param id
	 * @return
	 */
	SpecialistManagementBean getSpecialist(int id);
	/**
	 * 	更新专家数据
	 * @param specialist
	 * @return
	 */
	int updateSpecialist(SpecialistManagementBean specialist);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteSpecialist(int[] arr);
	/**
	 * 	根据条件查询
	 * @param map
	 * @return
	 */
	List<SpecialistManagementBean> getAllSpecialist(Map<String,Object> map);
	/**
	 * 	根据条件查询
	 * @param map
	 * @return
	 */
	int getAllSpecialistForNum(Map<String,Object> map);
	/**
	 * 	统计公司人数
	 * @return
	 */
	List<CompanyBean> getAllCompany();

}
