package com.one.test.expertConsultation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.dao.expertConsultation.ISpecialistDao;

public class SpecialistTest {
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
//	@Test
	public void testGetAllSpecialist() {
		ISpecialistDao spDao = session.getMapper(ISpecialistDao.class);
		Map<String,Object> map = new HashMap();
		map.put("name", "李");
		map.put("expertise", null);
		map.put("workUnit", null);
		map.put("pageNum", 0);
		map.put("pageSize", 2);
		List<SpecialistManagementBean> sp = spDao.getAllSpecialist(map);
		System.out.println(sp.size());
		System.out.println("============");
		session.close();
	}
//	@Test
	public void testGetSpecialist() {
		ISpecialistDao spDao = session.getMapper(ISpecialistDao.class);
		SpecialistManagementBean sp = spDao.getSpecialist(1);
		System.out.println(sp);
		session.close();
	}
	@Test
	public void testAddSpecialist() {
		ISpecialistDao spDao = session.getMapper(ISpecialistDao.class);
		SpecialistManagementBean sp = new SpecialistManagementBean();
		sp.setName("李四");
		sp.setBithday(new Date(new java.util.Date().getTime()));
		sp.setEmail("234234@qq.com");
		sp.setExpertise("业务");
		sp.setGender(true);
		sp.setPath("白草路");
		sp.setPhone("13412345678");
		sp.setPic("asdfasdf.jpg");
		sp.setPost("研究员");
		sp.setWorkUnit("市中心");
		spDao.addSpecialist(sp);
		session.commit();
	}
}
