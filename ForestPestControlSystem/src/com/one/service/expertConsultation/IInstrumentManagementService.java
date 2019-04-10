package com.one.service.expertConsultation;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.bean.expertConsultation.InstrumentManagementBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.service.expertConsultation.imp.InstrumentManagementServiceImp;

/**
 * 	专家会商
 * @author 49160
 *
 */
public interface IInstrumentManagementService {
	
	static IInstrumentManagementService getInstance() {
		return new InstrumentManagementServiceImp();
	}
	/**
	 * 查询事件记录并封装到pageBean对象
	 * @param pageNum 开始数据条数
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PageBean<List<IncidentRecordBean>> getIncidentRecordByStageId(int pageNum,int pageSize);

	/**
	 * 	添加会商记录
	 * @param imb
	 * @return
	 */
	int addInstrumentManagement(InstrumentManagementBean imb);
	/**
	 * 根据事件id来查询
	 * @param id
	 * @return
	 */
	IncidentRecordBean getIncidentRecordById(int id);
	/**
	 * 查询所有的会商结果
	 * @param map
	 * @return
	 */
	PageBean<List<InstrumentManagementBean>> getInstrumentManagement(int pageNum,int pageSize,int id);
	
	/**
	 * 查询所有导出Excel
	 * @return
	 */
	List<IncidentRecordBean> getIncidentRecordForExcel();
	
}
