package com.one.service.disposalManagement;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Consultation_managementBean;
import com.one.service.disposalManagement.imp.Consultation_managementServiceImp;

/**
 *  器械管理
 * @author 郑
 *
 */
public interface Consultation_managementService {

	static Consultation_managementService getInstance() {
		return new Consultation_managementServiceImp();
	}
	/**
	 *     添加器械
	 * @param consultation_managementBean
	 * @return
	 */
	public int add_instruments(Consultation_managementBean consultation_managementBean);
	/**
	 *  查询器械信息
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示条数
	 * @param name 器械名称
	 * @param type 防治类型
	 * @return 分页对象
	 */
	public PageBean<List<Consultation_managementBean>>getShowConsultation_management(int pageNum,int pageSize,String name,String type);
		
    }
