package com.one.dao.disasterPreventionAndControl;

import java.util.List;
import java.util.Map;

import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;

/**
 * 事件记录Dao
 * @author 16968
 *
 */
public interface IncidentRecordDao {

	/**
	 * 查询所有事件
	 * @return
	 */
	public List<IncidentRecordBean> getAllIncidentRecord(Map<String,Object> info);
	/**
	 * 添加事件
	 * @param incidentRecord 事件
	 * @return
	 */
	public int addIncidentRecord(IncidentRecordBean incidentRecord);
	/**
	 * 根据id查询事件
	 * @param id 事件id
	 * @return
	 */
	public IncidentRecordBean getIncidentRecordById(int id);
	/**
	 * 修改事件信息
	 * @param incidentRecord
	 * @return
	 */
	public int updateIncidentRecord(IncidentRecordBean incidentRecord);
	/**
	 * 申请专家会审
	 * @param incidentRecord 事件对象
	 * @return 
	 */
	public int applyForExpertReview(int id);
	/**
	 * 查询所有小班和地区
	 * @return
	 */
	public List<AreaInBean> getAllAreaAndSmall();
	
}






