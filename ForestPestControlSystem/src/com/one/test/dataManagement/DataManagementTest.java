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
		System.out.println("���Ϲ���ӿ�"+interDM);
		PestsBean pb = new PestsBean();
		pb.setAduitPic("2.jpg");
		pb.setHost("������");
		pb.setLarvaPic("1.jpg");
		pb.setMainHazards("Ӱ��ֲ�������������ľ����");
		pb.setPestisName("��Ҷ����");
		pb.setPreventiveMeasures("����27%ɱ��Һ��100����Һ�������޼�֦Ҷ");
		pb.setReproduction("�ļ���ֳ��һ̥���ٸ������ѵģ�һ�³ɳ�Ϊ�ɳ�");
		pb.setNaturalEnemy("��ѻ��èͷӥ");
		interDM.addPests(pb);
        session.commit();
	}
	
	@Test
	public void testAddDiseaseBean() {
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		//System.out.println("���Ϲ���ӿ�"+interDM);
		DiseaseBean ndb = new DiseaseBean();
		ndb.setDiseaseName("��������Ҷ��");
		ndb.setDiseasePic("5.jpg");
		ndb.setIncidenceRegularity("���ļ��ȼ����׷���������췴������");
		ndb.setMainHazards("��ɻ�������Ƭ����");
		ndb.setOnsetSymptom("����ǰ����Ҷȱ��Ӫ��������Ҷ�ƣ����ڿ�ʼ������Ҷ�Ϳ���");
		ndb.setPathology("���Ҿ��׷۾�Ŀ");
		ndb.setPreventiveMeasures("����޼��������Ⱦ֦Ҷ������20%������ɱ��Һ");
		
		interDM.addDiseaseBean(ndb);
        session.commit();
	}
	
	@Test
	public void testAddRodentpestsBean(){
		InterDataManagement interDM = session.getMapper(InterDataManagement.class);
		RodentpestsBean nrpb = new RodentpestsBean();
		nrpb.setMouseName("�ּ���");
		nrpb.setMainHazards("�ƻ�ֲ���͵���");
		nrpb.setMouseFoot("���ֹ��࣬����");
		nrpb.setMousePic("11.jpg");
		nrpb.setNaturalEnemy("���꣬�����ǣ��ߣ���ӥ");
		nrpb.setPreventiveMeasures("�����ߣ�èͷӥ����У����Ӳ���е���е��ɱ����Ȼ�ѧ����");
		nrpb.setReproduction("һ��6��8̥��һ̥7��10ֻ");
		interDM.addRodentpestsBean(nrpb);
		for(int i = 0 ;i<100;i++){
			nrpb.setMouseName("�ּ���"+i);
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
		System.out.println("���Բ�ѯ�󺦵Ľ��SIZE="+listRodent.size());
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
		System.out.println("���Բ�ѯ�����Ľ��SIZE="+listDiseas.size());
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
		System.out.println("���Բ�ѯ�����Ľ��SIZE="+listPests.size());
		session.close();
	}
}
