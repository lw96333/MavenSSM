package com.one.bean.dataManagement;

import java.io.Serializable;

    //病害一览
public class DiseaseBean implements Serializable {
	
	//病害ID
	private Integer diseaseId;
	
	//病害名称
	private String  diseaseName;
	
	//病理
	private String  pathology;
	
	//发病症状
	private String  onsetSymptom;
	
	//发病规律
	private String  incidenceRegularity;
	
	//图片
	private String  diseasePic;
	
	//防治措施
	private String  preventiveMeasures;
	
	//主要危害
	private String  mainHazards;
	
	//构造器
	public DiseaseBean(){
		
	}
	

	public DiseaseBean(Integer diseaseId, String diseaseName, String pathology, String onsetSymptom,
			String incidenceRegularity, String diseasePic, String preventiveMeasures, String mainHazards) {
		super();
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
		this.pathology = pathology;
		this.onsetSymptom = onsetSymptom;
		this.incidenceRegularity = incidenceRegularity;
		this.diseasePic = diseasePic;
		this.preventiveMeasures = preventiveMeasures;
		this.mainHazards = mainHazards;
	}

	
	
	@Override
	public String toString() {
		return "DiseaseBean [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", pathology=" + pathology
				+ ", onsetSymptom=" + onsetSymptom + ", incidenceRegularity=" + incidenceRegularity + ", diseasePic="
				+ diseasePic + ", preventiveMeasures=" + preventiveMeasures + ", mainHazards=" + mainHazards + "]";
	}


	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getPathology() {
		return pathology;
	}

	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	public String getOnsetSymptom() {
		return onsetSymptom;
	}

	public void setOnsetSymptom(String onsetSymptom) {
		this.onsetSymptom = onsetSymptom;
	}

	public String getIncidenceRegularity() {
		return incidenceRegularity;
	}

	public void setIncidenceRegularity(String incidenceRegularity) {
		this.incidenceRegularity = incidenceRegularity;
	}

	public String getDiseasePic() {
		return diseasePic;
	}

	public void setDiseasePic(String diseasePic) {
		this.diseasePic = diseasePic;
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
