package com.one.test.dataManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;
import com.one.dao.dataManagement.InterDataManagement;

public class DataManagementTest {
	private SqlSession session;
	@Before
	public void init() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddPests() {
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		System.out.println("资料管理接口"+interDM);
		PestsBean pb = new PestsBean();
		pb.setAduitPic("2.jpg");
		pb.setHost("白杨树");
		pb.setLarvaPic("1.jpg");
		pb.setMainHazards("影响植物生长，造成树木枯死");
		pb.setPestisName("枯叶黄螟");
		pb.setPreventiveMeasures("喷洒27%杀毒液，100倍溶液，并且修剪枝叶");
		pb.setReproduction("夏季繁殖，一胎多达百个，产卵的，一月成长为成虫");
		pb.setNaturalEnemy("乌鸦，猫头鹰");
		interDM.addPests(pb);
        session.commit();
	}
	
	@Test
	public void testAddDiseaseBean() {
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		//System.out.println("资料管理接口"+interDM);
		DiseaseBean ndb = new DiseaseBean();
		ndb.setDiseaseName("黄杨麻落叶病");
		ndb.setDiseasePic("5.jpg");
		ndb.setIncidenceRegularity("秋夏季度极容易发病，冰企鹅反复发作");
		ndb.setMainHazards("造成黄杨树大片枯死");
		ndb.setOnsetSymptom("发病前期树叶缺乏营养，中期叶黄，后期开始大量落叶和枯死");
		ndb.setPathology("子囊菌白粉菌目");
		ndb.setPreventiveMeasures("结合修剪，清楚感染枝叶，喷洒20%粉绣宁杀毒液");
		
		interDM.addDiseaseBean(ndb);
        session.commit();
	}
	
	@Test
	public void testAddRodentpestsBean(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		RodentpestsBean nrpb = new RodentpestsBean();
		nrpb.setMouseName("褐家鼠");
		nrpb.setMainHazards("破坏植被和电缆");
		nrpb.setMouseFoot("各种谷类，肉类");
		nrpb.setMousePic("11.jpg");
		nrpb.setNaturalEnemy("狐狸，黄鼠狼，蛇，老鹰");
		nrpb.setPreventiveMeasures("放养蛇，猫头鹰等天敌，增加捕鼠夹等器械，杀鼠灵等化学灭鼠");
		nrpb.setReproduction("一年6到8胎，一胎7到10只");
		interDM.addRodentpestsBean(nrpb);
		for(int i = 0 ;i<100;i++){
			nrpb.setMouseName("褐家鼠"+i);
			interDM.addRodentpestsBean(nrpb);
		}
        session.commit();
	}
	@Test
	public void testShowPestsInfoById(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		PestsBean spb = interDM.showPestsInfoById(1);
		System.out.println(spb);
		session.close();
	}
	@Test
	public void testShowDiseaseBeanInfoById(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		DiseaseBean db = interDM.showDiseaseBeanInfoById(2);
		System.out.println(db);
		session.close();
	}
	@Test
	public void testShowRodentpestsBeanInfoById(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		RodentpestsBean rtb = interDM.showRodentpestsBeanInfoById(3);
		System.out.println(rtb);
		session.close();
	}
	@Test
	public void testGetAllRodentpestsBeanList(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		Map<String,Object> map = new HashMap();
		map.put("pageNum", 0);
		map.put("pageSize", 5);
		map.put("TheMouseName", null);
		List<RodentpestsBean> listRodent = interDM.getAllRodentpestsBeanList(map);
		System.out.println("测试查询鼠害的结果SIZE="+listRodent.size());
		session.close();
	}

	@Test
	public void testGetAllDiseaseBeanList(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		Map<String,Object> map = new HashMap();
		map.put("pageNum", 0);
		map.put("pageSize", 5);
		map.put("TheDiseaseName", null);
		map.put("TheOnsetSymptom", null);
		List<DiseaseBean> listDiseas = interDM.getAllDiseaseBeanList(map);
		System.out.println("测试查询病害的结果SIZE="+listDiseas.size());
		session.close();
	}

	@Test
	public void testGetAllPestsBeanList(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		Map<String,Object> map = new HashMap();
		map.put("pageNum", 0);
		map.put("pageSize", 5);
		map.put("ThePestisName", null);
		map.put("TheHost", null);
		List<PestsBean> listPests = interDM.getAllPestsBeanList(map);
		System.out.println("测试查询病害的结果SIZE="+listPests.size());
		session.close();
	}
}
