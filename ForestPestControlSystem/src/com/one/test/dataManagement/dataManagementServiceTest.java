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
		pb.setHost("小叶杨");
		pb.setLarvaPic("2.jpg");
		pb.setMainHazards("啃噬树木嫩芽，影响树木生长，造成树木枯死");
		pb.setPestisName("小黄蛾");
		pb.setPreventiveMeasures("喷洒20%杀毒液，放养鸟类，1000倍溶液，并且修剪枝叶");
		pb.setReproduction("春夏季节繁殖，一胎多达百个，产卵的，一月成长为成虫");
		pb.setNaturalEnemy("乌鸦，麻雀，猫头鹰");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addPests(pb);
		System.out.println("测试服务层添加虫害，受影响的行数为： "+n);
	}
	//@Test
	public void testAddDiseaseBean(){
		DiseaseBean db = new DiseaseBean();
		db.setDiseaseName("松树幼果败落症");
		db.setDiseasePic("2.jpg");
		db.setIncidenceRegularity("白日以上级");
		db.setMainHazards("黄河如何让");
		db.setOnsetSymptom("采菊东篱下");
		db.setPathology("花儿红似火");
		db.setPreventiveMeasures("大漠孤烟直，长河落日圆");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addDiseaseBean(db);
		System.out.println("测试服务层添加病害，受影响的行数为： "+n);
	}
	
	//@Test
	public void testAddRodentpestsBean(){
		RodentpestsBean rb = new RodentpestsBean();
		rb.setMainHazards("一去二三里");
		rb.setMouseFoot("山村四五家");
		rb.setMouseName("黄山小灰鼠");
		rb.setMousePic("儿童六七个");
		rb.setNaturalEnemy("八九十之花");
		rb.setPreventiveMeasures("天王盖地虎");
		rb.setReproduction("西欧啊及炖蘑菇");
		InterDataManagementService idms = new DataManagementServiceImp();
		int n = idms.addRodentpestsBean(rb);
		System.out.println("测试服务层添加鼠害，受影响的行数为： "+n);
	}
	
	//@Test
	public void testShowPestsInfoById(){
		PestsBean pb = new PestsBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		pb = idms.showPestsInfoById(3);
		System.out.println("测试服务层查看虫害，结果为： "+pb);
	}
	
	//@Test
	public void testShowDiseaseBeanInfoById(){
		DiseaseBean db = new DiseaseBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		db = idms.showDiseaseBeanInfoById(3);
		System.out.println("测试服务层查看病害，结果为： "+db);
	}
	
	//@Test
	public void testShowRodentpestsBeanInfoById(){
		RodentpestsBean rb = new RodentpestsBean();
		InterDataManagementService idms = new DataManagementServiceImp();
		rb = idms.showRodentpestsBeanInfoById(4);
		System.out.println("测试服务层查看鼠害，结果为： "+rb);
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
	    page = idms.getAllDiseaseBeanList(1, 5, "白杨娟野螟", "单个病斑圆形，白色，病斑扩大，相互愈合后呈不规则形状");
	System.out.println("测试结果为：==>>>>>"+page.getPageData());
	}
	
	//@Test
	public void testGetAllRodentpestsBeanList(){
		PageBean<List<RodentpestsBean>> page = null;
		InterDataManagementService idms = new DataManagementServiceImp();
	    page = idms.getAllRodentpestsBeanList(5, 5, "");
	System.out.println("测试结果为："+page.toString());
	}
	
	
	
	
	
}
