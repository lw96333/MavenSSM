package com.one.bean.disasterPreventionAndControl;

import java.io.Serializable;
import java.util.Date;

import com.one.bean.DisasterStageBean;
import com.one.bean.DiscoveryPathBean;
import com.one.bean.PestTypesBean;
/**
 * 事件记录
 * @author 16968
 *
 */
public class IncidentRecordBean implements Serializable {

	private Integer id;
	/**
	 * 小班
	 */
	private SmallClassManagementBean smallClass;
	/**
	 * 发现途径
	 */
	private DiscoveryPathBean discovery;
	/**
	 * 灾害阶段
	 */
	private DisasterStageBean stage;
	/**
	 * 虫害类型
	 */
	private PestTypesBean pestType;
	/**
	 * 发生位置
	 */
	private AreaInBean area;
	/**
	 * 事件名称
	 */
	private String eventName;
	/**
	 * 灾区图片
	 */
	private String pic;
	/**
	 * 时间
	 */
	private Date time;
	/**
	 * 初步损失
	 */
	private String initialloss;
	/**
	 * 灾情描述
	 */
	private String disaster;
	/**
	 * 影响面积
	 */
	private String influence;
	/**
	 * 防治方案
	 */
	private String controlMethod;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SmallClassManagementBean getSmallClass() {
		return smallClass;
	}

	public void setSmallClass(SmallClassManagementBean smallClass) {
		this.smallClass = smallClass;
	}

	public DiscoveryPathBean getDiscovery() {
		return discovery;
	}

	public void setDiscovery(DiscoveryPathBean discovery) {
		this.discovery = discovery;
	}


	
	public DisasterStageBean getStage() {
		return stage;
	}

	public void setStage(DisasterStageBean stage) {
		this.stage = stage;
	}

	public PestTypesBean getPestType() {
		return pestType;
	}

	public void setPestType(PestTypesBean pestType) {
		this.pestType = pestType;
	}


	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getInitialloss() {
		return initialloss;
	}

	public void setInitialloss(String initialloss) {
		this.initialloss = initialloss;
	}

	public String getDisaster() {
		return disaster;
	}

	public void setDisaster(String disaster) {
		this.disaster = disaster;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public String getControlMethod() {
		return controlMethod;
	}

	public void setControlMethod(String controlMethod) {
		this.controlMethod = controlMethod;
	}

	public AreaInBean getArea() {
		return area;
	}

	public void setArea(AreaInBean area) {
		this.area = area;
	}
	
	
}
