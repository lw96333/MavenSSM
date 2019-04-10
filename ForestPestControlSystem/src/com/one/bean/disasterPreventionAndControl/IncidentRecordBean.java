package com.one.bean.disasterPreventionAndControl;

import java.io.Serializable;
import java.util.Date;

import com.one.bean.DisasterStageBean;
import com.one.bean.DiscoveryPathBean;
import com.one.bean.PestTypesBean;
/**
 * �¼���¼
 * @author 16968
 *
 */
public class IncidentRecordBean implements Serializable {

	private Integer id;
	/**
	 * С��
	 */
	private SmallClassManagementBean smallClass;
	/**
	 * ����;��
	 */
	private DiscoveryPathBean discovery;
	/**
	 * �ֺ��׶�
	 */
	private DisasterStageBean stage;
	/**
	 * �溦����
	 */
	private PestTypesBean pestType;
	/**
	 * ����λ��
	 */
	private AreaInBean area;
	/**
	 * �¼�����
	 */
	private String eventName;
	/**
	 * ����ͼƬ
	 */
	private String pic;
	/**
	 * ʱ��
	 */
	private Date time;
	/**
	 * ������ʧ
	 */
	private String initialloss;
	/**
	 * ��������
	 */
	private String disaster;
	/**
	 * Ӱ�����
	 */
	private String influence;
	/**
	 * ���η���
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
