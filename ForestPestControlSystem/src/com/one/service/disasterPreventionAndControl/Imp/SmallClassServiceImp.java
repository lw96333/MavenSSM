package com.one.service.disasterPreventionAndControl.Imp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.dao.disasterPreventionAndControl.AreaInDao;
import com.one.dao.disasterPreventionAndControl.SmallClassManagementDao;
import com.one.service.disasterPreventionAndControl.SmallClassService;

public class SmallClassServiceImp implements SmallClassService {
	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}

	@Override
	public PageBean<List<SmallClassManagementBean>> getAllSmallClassManagement(int pageNum, int pageSize, String smallClassName,
			String areaName) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> mapList = new HashMap<String,Object>();
		
		PageBean<List<SmallClassManagementBean>> page = new PageBean<>();
		page.setPageNum((pageNum - 1) * pageSize);
		page.setPageSize(pageSize);
		if("".equals(smallClassName)) {
			map.put("smName", null);
			mapList.put("smName", null);
		}else {
			map.put("smName", smallClassName);
			mapList.put("smName", smallClassName);
		}
		if("".equals(areaName)) {
			map.put("regName", null);
			mapList.put("regName", null);
		}else {
			map.put("regName", areaName);
			mapList.put("regName", areaName);
		}
		map.put("pageNum", page);
		mapList.put("pageNum", null);
		
		SqlSession session = null;
		List list = null;
		List<SmallClassManagementBean> liTotal = null;
		
		try {
			session = this.getSession();
			SmallClassManagementDao smallClass = session.getMapper(SmallClassManagementDao.class);
			liTotal = smallClass.getAllSmallClassManagement(mapList);
			list = smallClass.getAllSmallClassManagement(map);
			page.setPageData(list);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return page;
	}

	@Override
	public int addSmallClass(SmallClassManagementBean smallClass) {
		SqlSession session = null;
		try {
			session = this.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SmallClassManagementDao smallClassDao = session.getMapper(SmallClassManagementDao.class);
		int num = smallClassDao.addSmallClass(smallClass);
		session.commit();
		return num;
	}

	@Override
	public SmallClassManagementBean getSmallClassInfoById(int id) {
		SqlSession session = null;
		try {
			session = this.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SmallClassManagementDao smallClassDao = session.getMapper(SmallClassManagementDao.class);
		SmallClassManagementBean num = smallClassDao.getSmallClassInfoById(id);
		session.commit();
		return num;
	}

	@Override
	public int updateSmallClassById(SmallClassManagementBean small) {
		SqlSession session = null;
		try {
			session = this.getSession();
			SmallClassManagementDao smallClassDao = session.getMapper(SmallClassManagementDao.class);
			int num = smallClassDao.updateSmallClassById(small);
			session.commit();
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SmallClassManagementBean> getAllSmallClassManagementByName() {
		// TODO Auto-generated method stub
		SqlSession session = null;
		List<SmallClassManagementBean> area = null;
		try {
			session = this.getSession();
			SmallClassManagementDao smallClassDao = session.getMapper(SmallClassManagementDao.class);
			area = smallClassDao.getAllSmallClassManagementByName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

}
