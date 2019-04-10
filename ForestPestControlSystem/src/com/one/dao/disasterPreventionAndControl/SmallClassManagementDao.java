package com.one.dao.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;

/**
 * С�����Dao
 * @author 16968
 *
 */
public interface SmallClassManagementDao {

	/**
	 * 
	 * @return ��ѯ����С��
	 */
	public List<SmallClassManagementBean> getAllSmallClassManagement(Map<String, Object> map);
	/**
	 * 
	 * @return ��ѯ����С������
	 */
	public List<SmallClassManagementBean> getAllSmallClassManagementByName();
	/**
	 * ����С��
	 * @param smallClass С��
	 * @return �Ƿ����ӳɹ�
	 */
	public int addSmallClass(SmallClassManagementBean smallClass);
	/**
	 * �鿴С����Ϣ
	 * @param id С��ID
	 * @return С����Ϣ
	 */
	public SmallClassManagementBean getSmallClassInfoById(int id);
	/**
	 * �޸�С����Ϣ
	 * @param  small С��
	 * @return �Ƿ��޸ĳɹ�
	 */
	public int updateSmallClassById(SmallClassManagementBean small);
	
}