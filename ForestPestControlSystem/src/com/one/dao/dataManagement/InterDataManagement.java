package com.one.dao.dataManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;


public interface InterDataManagement {
	
	/**
	 * 添加虫害
	 * @param pestsBean 由页面信息构建的对象，即需要添加到数据库中的PestsBean对象
	 * @return  返回值，为影响数据库中的行数，1表示影响1行，即添加成功
	 */
	public int addPests(PestsBean pestsBean);
	
	/**
	 * 查看虫害详细信息
	 * @param id 需要查看的PestsBean 的id
	 * @return 数据库中返回该id对应的PestsBean对象
	 */
	public PestsBean showPestsInfoById(int id);

	/**
	 * 添加病害
	 * @param diseaseBean 页面信息构成的需要添加到数据库的对象
	 * @return 返回影响数据库中的行数，为1表示数据库添加成功
	 */
	public int addDiseaseBean(DiseaseBean diseaseBean);
	
	/**
	 * 查看病害详细信息
	 * @param id 需要查看的病害id
	 * @return 返回该id所对应的病害对象
	 */
	public DiseaseBean showDiseaseBeanInfoById(int id);
	
	/**
	 * 添加鼠害
	 * @param rodentpestsBean 页面信息构建的鼠害对象，即需要添加到数据库的对象
	 * @return 返回值表示数据库中受影响的行数，返回1代表添加成功
	 */
	public int addRodentpestsBean(RodentpestsBean rodentpestsBean);
	
	/**
	 * 查看鼠害具体信息
	 * @param id 需要查看的id
	 * @return 返回该id对应的鼠害对象
	 */
	public RodentpestsBean showRodentpestsBeanInfoById(int id);
	
	/**
	 * 按条件查询所有鼠害
	 * @param map  查询条件
	 * @return 符合条件的所有鼠害
	 */
	public List<RodentpestsBean> getAllRodentpestsBeanList(Map<String,Object> map);
	
	/**
	 * 按条件查询所有病害
	 * @param map  查询条件
	 * @return 查询结果
	 */
	public List<DiseaseBean> getAllDiseaseBeanList(Map<String,Object> map);
	
	/**
	 * 按条件查所有询虫害
	 * @param map查询条件
	 * @return 返回结果
	 */
	public List<PestsBean> getAllPestsBeanList(Map<String,Object> map);

	
}
