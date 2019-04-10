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
import com.one.bean.disposalManagement.Pharmacy_managementBean;
import com.one.dao.disposalManagement.Pharmacy_managementDao;
import com.one.service.disposalManagement.Pharmacy_managementService;

public class Pharmacy_managementServiceImp implements Pharmacy_managementService{

	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}
	
	@Override
	public int additive(Pharmacy_managementBean pmt) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = this.getSession();
			Pharmacy_managementDao cm = session.getMapper(Pharmacy_managementDao.class);
			num = cm.additive(pmt);
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
	public PageBean<List<Pharmacy_managementBean>> getShowPharmacy_management(int pageNum, int pageSize, String name,
			String type, String diseasesType) {
		// TODO Auto-generated method stub
//		System.out.println(name+"11111122"+type+"2222222222211"+diseasesType+"3333333333322");
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
		if("".equals(diseasesType)) {
			map.put("diseasesType", null);
			mapTotal.put("diseasesType", null);
		}else {
			map.put("diseasesType", diseasesType);
			mapTotal.put("diseasesType", diseasesType);
		}
	
		mapTotal.put("pageNum", null);
		map.put("pageSize", pageSize);
		mapTotal.put("pageSize", null);
		
		SqlSession session = null;
		List li = null;
		List<Pharmacy_managementBean> liTotal = null;
		PageBean<List<Pharmacy_managementBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			Pharmacy_managementDao isd = session.getMapper(Pharmacy_managementDao.class);
			liTotal = isd.getAllPharmacy_management(mapTotal);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
//			System.out.println(pageNum);
			page.setPageSize(pageSize);
			
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
//			System.out.println(pageNum + "====" +pageSize );
//			System.out.println((pageNum - 1) * pageSize);
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = isd.getAllPharmacy_management(map);
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
