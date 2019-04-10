package com.one.dao.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;

/**
 * �¼���¼Dao
 * @author 16968
 *
 */
public interface IncidentRecordDao {

	/**
	 * ��ѯ�����¼�
	 * @return
	 */
	public List<IncidentRecordBean> getAllIncidentRecord(Map<String,Object> info);
	/**
	 * ����¼�
	 * @param incidentRecord �¼�
	 * @return
	 */
	public int addIncidentRecord(IncidentRecordBean incidentRecord);
	/**
	 * ����id��ѯ�¼�
	 * @param id �¼�id
	 * @return
	 */
	public IncidentRecordBean getIncidentRecordById(int id);
	/**
	 * �޸��¼���Ϣ
	 * @param incidentRecord
	 * @return
	 */
	public int updateIncidentRecord(IncidentRecordBean incidentRecord);
	/**
	 * ����ר�һ���
	 * @param incidentRecord �¼�����
	 * @return 
	 */
	public int applyForExpertReview(int id);
	/**
	 * ��ѯ����С��͵���
	 * @return
	 */
	public List<AreaInBean> getAllAreaAndSmall();
	
}






