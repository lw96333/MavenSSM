package com.one.service.disasterPreventionAndControl;

import java.util.List;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;

public interface IncidentService {
	/**
	 * ��ѯ�����¼�
	 * @return
	 */
	public PageBean<List<IncidentRecordBean>> getAllIncidentRecord(int pageNum, int pageSize, String incidenName,
			String areaName, String disasterStageType);
	/**
	 * �����¼�
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