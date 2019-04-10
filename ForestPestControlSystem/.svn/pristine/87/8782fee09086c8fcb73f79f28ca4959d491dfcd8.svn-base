package com.one.service.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Pharmacy_managementBean;
import com.one.service.disposalManagement.imp.Pharmacy_managementServiceImp;

/**
 *  药剂管理
 * @author 郑
 *
 */
public interface Pharmacy_managementService {

	static Pharmacy_managementService getInstance() {
		return new Pharmacy_managementServiceImp();
	}
	
	/**
	 *   添加药剂
	 * @param pmt
	 * @return
	 */
	public int additive(Pharmacy_managementBean pmt);
	/**
	 *     查询药剂信息
	 * @param pageNum  当前页数
	 * @param pageSize 每页显示条数
	 * @param name 药剂名称
	 * @param type 防治类型
	 * @param diseasesType 病虫害类型
	 * @return 分页对象
	 */
	public PageBean<List<Pharmacy_managementBean>> getShowPharmacy_management(int pageNum,int pageSize,String name,String type,String diseasesType);
}
