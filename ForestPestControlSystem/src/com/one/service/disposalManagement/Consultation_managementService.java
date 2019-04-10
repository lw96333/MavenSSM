package com.one.service.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Consultation_managementBean;
import com.one.service.disposalManagement.imp.Consultation_managementServiceImp;

/**
 *  ��е����
 * @author ֣
 *
 */
public interface Consultation_managementService {

	static Consultation_managementService getInstance() {
		return new Consultation_managementServiceImp();
	}
	/**
	 *     �����е
	 * @param consultation_managementBean
	 * @return
	 */
	public int add_instruments(Consultation_managementBean consultation_managementBean);
	/**
	 *  ��ѯ��е��Ϣ
	 * @param pageNum ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ����
	 * @param name ��е����
	 * @param type ��������
	 * @return ��ҳ����
	 */
	public PageBean<List<Consultation_managementBean>>getShowConsultation_management(int pageNum,int pageSize,String name,String type);
		
    }
