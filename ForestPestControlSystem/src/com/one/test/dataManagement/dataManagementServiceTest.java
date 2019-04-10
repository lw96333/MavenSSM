package com.one.test.dataManagement;

import java.util.List;

import org.junit.Test;

import com.one.bean.PageBean;
import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;
import com.one.service.dataManagement.InterDataManagementService;
import com.one.service.dataManagement.imp.DataManagementServiceImp;

public class dataManagementServiceTest {
 
	//@Test
	public void testAddPests(){
		PestsBean pb = new PestsBean();
		pb.setAduitPic("2.jpg");
		pb.setHost("СҶ��");
		pb.setLarvaPic("2.jpg");
		pb.setMainHazards("������ľ��ѿ��Ӱ����ľ�����������ľ����");
		pb.setPestisName("С�ƶ�");
		pb.setPreventiveMeasures("����20%ɱ��Һ���������࣬1000����Һ�������޼�֦Ҷ");
		pb.setReproduction("���ļ��ڷ�ֳ��һ̥���ٸ������ѵģ�һ�³ɳ�Ϊ�ɳ�");
		pb.setNaturalEnemy("��ѻ����ȸ��èͷӥ");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addPests(pb);
		System.out.println("���Է������ӳ溦����Ӱ�������Ϊ�� "+n);
	}
	//@Test
	public void testAddDiseaseBean(){
		DiseaseBean db = new DiseaseBean();
		db.setDiseaseName("�����׹�����֢");
		db.setDiseasePic("2.jpg");
		db.setIncidenceRegularity("�������ϼ�");
		db.setMainHazards("�ƺ������");
		db.setOnsetSymptom("�ɾն�����");
		db.setPathology("�������ƻ�");
		db.setPreventiveMeasures("��Į����ֱ����������Բ");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addDiseaseBean(db);
		System.out.println("���Է������Ӳ�������Ӱ�������Ϊ�� "+n);
	}
	
	//@Test
	public void testAddRodentpestsBean(){
		RodentpestsBean rb = new RodentpestsBean();
		rb.setMainHazards("һȥ������");
		rb.setMouseFoot("ɽ�������");
		rb.setMouseName("��ɽС����");
		rb.setMousePic("��ͯ���߸�");
		rb.setNaturalEnemy("�˾�ʮ֮��");
		rb.setPreventiveMeasures("�����ǵػ�");
		rb.setReproduction("��ŷ������Ģ��");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addRodentpestsBean(rb);
		System.out.println("���Է��������󺦣���Ӱ�������Ϊ�� "+n);
	}
	
	//@Test
	public void testShowPestsInfoById(){
		PestsBean pb = new PestsBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		pb = idms.showPestsInfoById(3);
		System.out.println("���Է����鿴�溦�����Ϊ�� "+pb);
	}
	
	//@Test
	public void testShowDiseaseBeanInfoById(){
		DiseaseBean db = new DiseaseBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		db = idms.showDiseaseBeanInfoById(3);
		System.out.println("���Է����鿴���������Ϊ�� "+db);
	}
	
	//@Test
	public void testShowRodentpestsBeanInfoById(){
		RodentpestsBean rb = new RodentpestsBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		rb = idms.showRodentpestsBeanInfoById(4);
		System.out.println("���Է����鿴�󺦣����Ϊ�� "+rb);
	}
	
	//@Test// youcou
	public void testGetAllPestsBeanList(){
		PageBean<List<PestsBean>> page = null;
		InterDataManagementService idms = new DataManagementServiceImp();
		page = idms.getAllPestsBeanList(1, 5,"","");
		System.out.println(page);
	}
	
	@Test
	public void testGetAllDiseaseBeanList(){
		PageBean<List<DiseaseBean>> page = null;
		InterDataManagementService idms = new DataManagementServiceImp();
	    page = idms.getAllDiseaseBeanList(1, 5, "�����Ұ��", "��������Բ�Σ���ɫ�����������໥���Ϻ�ʲ�������״");
	System.out.println("���Խ��Ϊ��==>>>>>"+page.getPageData());
	}
	
	//@Test
	public void testGetAllRodentpestsBeanList(){
		PageBean<List<RodentpestsBean>> page = null;
		InterDataManagementService idms = new DataManagementServiceImp();
	    page = idms.getAllRodentpestsBeanList(5, 5, "");
	System.out.println("���Խ��Ϊ��"+page.toString());
	}
	
	
	
	
	
}
