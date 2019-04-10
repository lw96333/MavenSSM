package com.one.service.expertConsultation;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.bean.expertConsultation.InstrumentManagementBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.service.expertConsultation.imp.InstrumentManagementServiceImp;

/**
 * 	ר�һ���
 * @author 49160
 *
 */
public interface IInstrumentManagementService {
	
	static IInstrumentManagementService getInstance() {
		return new InstrumentManagementServiceImp();
	}
	/**
	 * ��ѯ�¼���¼����װ��pageBean����
	 * @param pageNum ��ʼ��������
	 * @param pageSize ÿҳ��ʾ����
	 * @return
	 */
	PageBean<List<IncidentRecordBean>> getIncidentRecordByStageId(int pageNum,int pageSize);

	/**
	 * 	��ӻ��̼�¼
	 * @param imb
	 * @return
	 */
	int addInstrumentManagement(InstrumentManagementBean imb);
	/**
	 * �����¼�id����ѯ
	 * @param id
	 * @return
	 */
	IncidentRecordBean getIncidentRecordById(int id);
	/**
	 * ��ѯ���еĻ��̽��
	 * @param map
	 * @return
	 */
	PageBean<List<InstrumentManagementBean>> getInstrumentManagement(int pageNum,int pageSize,int id);
	
	/**
	 * ��ѯ���е���Excel
	 * @return
	 */
	List<IncidentRecordBean> getIncidentRecordForExcel();
	
}
