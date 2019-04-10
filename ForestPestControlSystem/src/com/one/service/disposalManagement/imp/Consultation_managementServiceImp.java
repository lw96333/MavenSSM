package com.one.service.disposalManagement.imp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Consultation_managementBean;
import com.one.dao.disposalManagement.Consultation_managementDao;
import com.one.service.disposalManagement.Consultation_managementService;

public class Consultation_managementServiceImp implements Consultation_managementService {
	
	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}

	@Override
	public int add_instruments(Consultation_managementBean consultation_managementBean) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = this.getSession();
			Consultation_managementDao cm = session.getMapper(Consultation_managementDao.class);
			num = cm.add_instruments(consultation_managementBean);
//			System.out.println(num+"2222222222222");
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
			
		}
		return num;
	}

	@Override
	public PageBean<List<Consultation_managementBean>> getShowConsultation_management(int pageNum, int pageSize,
			String name, String type) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
		Map<String,Object> mapTotal = new HashMap();
		if("".equals(name)) {
			map.put("name", null);
			mapTotal.put("name", null);
		}else {
			map.put("name", name);
			mapTotal.put("name", name);
		}
		if("".equals(type)) {
			map.put("type", null);
			mapTotal.put("type", null);
		}else {
			map.put("type", type);
			mapTotal.put("type", type);
		}
	
		mapTotal.put("pageNum", null);
		map.put("pageSize", pageSize);
		mapTotal.put("pageSize", null);
		
		SqlSession session = null;
		List li = null;
		List<Consultation_managementBean> liTotal = null;
		PageBean<List<Consultation_managementBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			Consultation_managementDao isd = session.getMapper(Consultation_managementDao.class);
			liTotal = isd.getAllConsultation_management(mapTotal);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
//			System.out.println(pageNum + "====" +pageSize );
//			System.out.println((pageNum - 1) * pageSize);
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = isd.getAllConsultation_management(map);
			page.setPageData(li);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
			
		}
		return page;
	}
	
}

	
	

