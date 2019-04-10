package com.one.bean.dataManagement;

import java.io.Serializable;
    //³æº¦Ò»ÀÀ
public class PestsBean implements Serializable{
	//	³æº¦ID
	private Integer pestisId;
	
	//³æº¦Ãû³Æ
	private String  pestisName ;
	
	//³æº¦¼ÄÖ÷
	private String 	host ;
	
	//³æº¦·±Ö³
	private String  reproduction ;
	
	//³æº¦ÌìµÐ
	private String  naturalEnemy ;
	
	//Ó×³æÍ¼Æ¬
	private String  larvaPic ;
	
	//³É³æÍ¼Æ¬
	private String  aduitPic ;
	
	//³æº¦·ÀÖÎ´ëÊ©
	private String  preventiveMeasures ;
	
	//Ö÷ÒªÎ£º¦
	private String  mainHazards ;
	
	//˜‹ÔìÆ÷
	
	public PestsBean(){
		
	}


	public PestsBean(Integer pestisId, String pestisName, String host, String reproduction, String naturalEnemy,
			String larvaPic, String aduitPic, String preventiveMeasures, String mainHazards) {
		super();
		this.pestisId = pestisId;
		this.pestisName = pestisName;
		this.host = host;
		this.reproduction = reproduction;
		this.naturalEnemy = naturalEnemy;
		this.larvaPic = larvaPic;
		this.aduitPic = aduitPic;
		this.preventiveMeasures = preventiveMeasures;
		this.mainHazards = mainHazards;
	}

	@Override
	public String toString() {
		return "PestsBean [pestisId=" + pestisId + ", pestisName=" + pestisName + ", host=" + host + ", reproduction="
				+ reproduction + ", naturalEnemy=" + naturalEnemy + ", larvaPic=" + larvaPic + ", aduitPic=" + aduitPic
				+ ", preventiveMeasures=" + preventiveMeasures + ", mainHazards=" + mainHazards + "]";
	}


	public Integer getPestisId() {
		return pestisId;
	}
	
	public void setPestisId(Integer pestisId) {
		this.pestisId = pestisId;
	}

	public String getPestisName() {
		return pestisName;
	}

	public void setPestisName(String pestisName) {
		this.pestisName = pestisName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getReproduction() {
		return reproduction;
	}

	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	public String getNaturalEnemy() {
		return naturalEnemy;
	}

	public void setNaturalEnemy(String naturalEnemy) {
		this.naturalEnemy = naturalEnemy;
	}

	public String getLarvaPic() {
		return larvaPic;
	}

	public void setLarvaPic(String larvaPic) {
		this.larvaPic = larvaPic;
	}

	public String getAduitPic() {
		return aduitPic;
	}

	public void setAduitPic(String aduitPic) {
		this.aduitPic = aduitPic;
	}

	public String getPreventiveMeasures() {
		return preventiveMeasures;
	}

	public void setPreventiveMeasures(String preventiveMeasures) {
		this.preventiveMeasures = preventiveMeasures;
	}

	public String getMainHazards() {
		return mainHazards;
	}

	public void setMainHazards(String mainHazards) {
		this.mainHazards = mainHazards;
	}
	
	
	
}
