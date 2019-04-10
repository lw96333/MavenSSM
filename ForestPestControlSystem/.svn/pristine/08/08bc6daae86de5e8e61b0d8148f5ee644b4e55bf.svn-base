package com.one.test.disposalManagement;

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

import com.one.bean.PestTypesBean;
import com.one.bean.disposalManagement.Consultation_managementBean;
import com.one.dao.disposalManagement.Consultation_managementDao;

public class Consultation_managementTest {

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
	public void testGetAllConsultation_management() {
		Consultation_managementDao consultation_managementDao = session.getMapper(Consultation_managementDao.class);
		Map<String,Object> map = new HashMap();
		map.put("name", "1");
		map.put("type", null);
		map.put("purpose", null);
		map.put("pageNum", 0);
		map.put("pageSize", 2);
		List<Consultation_managementBean> sp = consultation_managementDao.getAllConsultation_management(map);
		System.out.println(sp.size());
		System.out.println("============");
		session.close();
		
    }
	@Test
	public void testAdd_instruments() {
		Consultation_managementDao cm = session.getMapper(Consultation_managementDao.class);
		Consultation_managementBean sp = new Consultation_managementBean();
		sp.setName("≤∂ Û∞Â");
		sp.setPurpose("”’…±¥Û¿œ Û");
		PestTypesBean pb = new PestTypesBean();
		pb.setInsectId(2);
		pb.setType(" Û∫¶");
		sp.setInsect(pb);
		cm.add_instruments(sp);
		
		session.commit();
	}
}
