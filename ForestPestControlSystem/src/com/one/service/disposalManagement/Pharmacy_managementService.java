package com.one.service.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Pharmacy_managementBean;
import com.one.service.disposalManagement.imp.Pharmacy_managementServiceImp;

/**
 *  ҩ������
 * @author ֣
 *
 */
public interface Pharmacy_managementService {

	static Pharmacy_managementService getInstance() {
		return new Pharmacy_managementServiceImp();
	}
	
	/**
	 *   ���ҩ��
	 * @param pmt
	 * @return
	 */
	public int additive(Pharmacy_managementBean pmt);
	/**
	 *     ��ѯҩ����Ϣ
	 * @param pageNum  ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ����
	 * @param name ҩ������
	 * @param type ��������
	 * @param diseasesType ���溦����
	 * @return ��ҳ����
	 */
	public PageBean<List<Pharmacy_managementBean>> getShowPharmacy_management(int pageNum,int pageSize,String name,String type,String diseasesType);
}
