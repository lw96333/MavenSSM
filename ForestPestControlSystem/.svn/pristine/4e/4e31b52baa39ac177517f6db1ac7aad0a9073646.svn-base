package com.one.test.expertConsultation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.one.dao.expertConsultation.IInstrumentManagementDao;

public class IInstrumentManagementTest {
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
	public void testGetIncidentRecordByStageId() {
		Map map = new HashMap();
		map.put("pageNum", 1);
		map.put("pageSize", 2);
		IInstrumentManagementDao imd = session.getMapper(IInstrumentManagementDao.class);
		System.out.println(imd.getIncidentRecordByStageId(map).size());
	}
}
