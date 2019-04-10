//package com.one.test.disposalManagement;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.one.bean.DiseasesAndInsectPestsBean;
//import com.one.bean.PestTypesBean;
//import com.one.bean.disposalManagement.Pharmacy_managementBean;
//import com.one.dao.disposalManagement.Pharmacy_managementDao;
//
//public class Pharmacy_managementTest {
//
//	private SqlSession session;
//	
//	@Before
//	public void init() {
//		InputStream inputStream = null;
//		try {
//			inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
//			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//			session = factory.openSession();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void testgetAllPharmacy_management() {
//		// TODO Auto-generated method stub
//		Pharmacy_managementDao pmDao = session.getMapper(Pharmacy_managementDao.class);
//		Map<String,Object> map = new HashMap();
//		map.put("name", "1");
//		map.put("type", null);
//		map.put("purpose", null);
//		map.put("pageNum", 0);
//		map.put("pageSize", 2);
//		List<Pharmacy_managementBean> sp = pmDao.getAllPharmacy_management(map);
//		System.out.println(sp.size());
//		System.out.println("============");
//		session.close();
//	}
//	@Test
//	public void testAdditive() {
//		Pharmacy_managementDao pmDao = session.getMapper(Pharmacy_managementDao.class);
//		Pharmacy_managementBean pmb = new Pharmacy_managementBean();
//		pmb.setName("��ҩ");
//		pmb.setTree("����");
//		PestTypesBean pb = new PestTypesBean();
//		pb.setType("��");
//		pmb.setInsect(pb);
//		DiseasesAndInsectPestsBean dp = new DiseasesAndInsectPestsBean();
//		dp.setDiseasesId(1);
//		dp.setDiseasesType("���");
//		pmb.setDiseases(dp);
//		
//		pmDao.additive(pmb);
//		session.close();
//	}
//}
