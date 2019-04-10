package com.one.service.dataManagement;

import java.util.List;

import com.one.bean.PageBean;
import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;
import com.one.service.dataManagement.imp.DataManagementServiceImp;


/**
 *  资料管理
 * @author Administrator
 *
 */
public interface InterDataManagementService {
	
	static InterDataManagementService getInstance(){
		
		return new DataManagementServiceImp() ;
		
	}
	/**
	 * 添加虫害
	 * @param pestsBean
	 * @return
	 */
	public int addPests(PestsBean pestsBean);
	
	/**
	 * 查看虫害
	 * @param id
	 * @return
	 */
	public PestsBean showPestsInfoById(int id);
	
	/**
	 * 添加病害
	 * @param diseaseBean
	 * @return
	 */
	public int addDiseaseBean(DiseaseBean diseaseBean);
	
	/**
	 * 查看病害
	 * @param id
	 * @return
	 */
	public DiseaseBean showDiseaseBeanInfoById(int id);
	
	/**
	 * 添加鼠害
	 * @param rodentpestsBean
	 * @return
	 */
	public int addRodentpestsBean(RodentpestsBean rodentpestsBean);
	
	/**
	 * 查看鼠害
	 * @param id
	 * @return
	 */
	public RodentpestsBean showRodentpestsBeanInfoById(int id);
	
	/**
	 * 显示查询的虫害
	 * @param pageNum 当前页数
	 * @param pageSize 当前页显示的条数
	 * @param ThePestisName 查询条件 虫害名称
	 * @param TheHost 查询条件 虫害寄主
	 * @return 返回分页对象
	 */
	public PageBean<List<PestsBean>> getAllPestsBeanList(int pageNum,int pageSize,String ThePestisName,String TheHost);
	
	/**
	 * 显示查询的病害
	 * @param pageNum 当前页数
	 * @param pageSize 当前条数
	 * @param TheDiseaseName 病害名称
	 * @param TheOnsetSymptom 病害病症
	 * @return 返回分页对象
	 */
	public PageBean<List<DiseaseBean>> getAllDiseaseBeanList(int pageNum,int pageSize,String TheDiseaseName,String TheOnsetSymptom);
	
	/**
	 * 按提条件查询鼠害
	 * @param pageNum 当前页数
	 * @param pageSize 页面条数
	 * @param TheMouseName 查询条件 老鼠名称
	 * @return 返回分页对象
	 */
	public PageBean<List<RodentpestsBean>> getAllRodentpestsBeanList(int pageNum,int pageSize,String TheMouseName);

}
