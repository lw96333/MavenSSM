package com.one.dao.expertConsultation;

import java.util.List;
import java.util.Map;

import com.one.bean.CompanyBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
/**
 * 	ר��һ��Dao
 * @author 49160
 *
 */
public interface ISpecialistDao {
	/**
	 * 	����ר��
	 * @param specialist
	 * @return
	 */
	int addSpecialist(SpecialistManagementBean specialist);
	/**
	 * 	����ID��ѯר��
	 * @param id
	 * @return
	 */
	SpecialistManagementBean getSpecialist(int id);
	/**
	 * 	����ר������
	 * @param specialist
	 * @return
	 */
	int updateSpecialist(SpecialistManagementBean specialist);
	/**
	 * ����idɾ��
	 * @param id
	 * @return
	 */
	int deleteSpecialist(int[] arr);
	/**
	 * 	����������ѯ
	 * @param map
	 * @return
	 */
	List<SpecialistManagementBean> getAllSpecialist(Map<String,Object> map);
	/**
	 * 	����������ѯ
	 * @param map
	 * @return
	 */
	int getAllSpecialistForNum(Map<String,Object> map);
	/**
	 * 	ͳ�ƹ�˾����
	 * @return
	 */
	List<CompanyBean> getAllCompany();

}