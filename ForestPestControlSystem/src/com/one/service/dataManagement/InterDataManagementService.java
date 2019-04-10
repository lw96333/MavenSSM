package com.one.service.dataManagement;

import java.util.List;

import com.one.bean.PageBean;
import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;
import com.one.service.dataManagement.imp.DataManagementServiceImp;


/**
 *  ���Ϲ���
 * @author Administrator
 *
 */
public interface InterDataManagementService {
	
	static InterDataManagementService getInstance(){
		
		return new DataManagementServiceImp() ;
		
	}
	/**
	 * ��ӳ溦
	 * @param pestsBean
	 * @return
	 */
	public int addPests(PestsBean pestsBean);
	
	/**
	 * �鿴�溦
	 * @param id
	 * @return
	 */
	public PestsBean showPestsInfoById(int id);
	
	/**
	 * ��Ӳ���
	 * @param diseaseBean
	 * @return
	 */
	public int addDiseaseBean(DiseaseBean diseaseBean);
	
	/**
	 * �鿴����
	 * @param id
	 * @return
	 */
	public DiseaseBean showDiseaseBeanInfoById(int id);
	
	/**
	 * �����
	 * @param rodentpestsBean
	 * @return
	 */
	public int addRodentpestsBean(RodentpestsBean rodentpestsBean);
	
	/**
	 * �鿴��
	 * @param id
	 * @return
	 */
	public RodentpestsBean showRodentpestsBeanInfoById(int id);
	
	/**
	 * ��ʾ��ѯ�ĳ溦
	 * @param pageNum ��ǰҳ��
	 * @param pageSize ��ǰҳ��ʾ������
	 * @param ThePestisName ��ѯ���� �溦����
	 * @param TheHost ��ѯ���� �溦����
	 * @return ���ط�ҳ����
	 */
	public PageBean<List<PestsBean>> getAllPestsBeanList(int pageNum,int pageSize,String ThePestisName,String TheHost);
	
	/**
	 * ��ʾ��ѯ�Ĳ���
	 * @param pageNum ��ǰҳ��
	 * @param pageSize ��ǰ����
	 * @param TheDiseaseName ��������
	 * @param TheOnsetSymptom ������֢
	 * @return ���ط�ҳ����
	 */
	public PageBean<List<DiseaseBean>> getAllDiseaseBeanList(int pageNum,int pageSize,String TheDiseaseName,String TheOnsetSymptom);
	
	/**
	 * ����������ѯ��
	 * @param pageNum ��ǰҳ��
	 * @param pageSize ҳ������
	 * @param TheMouseName ��ѯ���� ��������
	 * @return ���ط�ҳ����
	 */
	public PageBean<List<RodentpestsBean>> getAllRodentpestsBeanList(int pageNum,int pageSize,String TheMouseName);

}
