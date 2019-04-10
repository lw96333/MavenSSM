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
import com.one.dao.disasterPreventionAndControl.AreaInDao;
import com.one.service.disasterPreventionAndControl.AreaInService;

public class AreaInServiceImp implements AreaInService {

	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}
	@Override
	public PageBean<List<AreaInBean>> getAllAreaIn(int pageNum, int pageSize, String forest,
			String advantage) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> mapList = new HashMap<String,Object>();
		
		PageBean<List<AreaInBean>> page = new PageBean<>();
		page.setPageNum((pageNum - 1) * pageSize);
		page.setPageSize(pageSize);
		if("".equals(forest)) {
			map.put("forest", null);
			mapList.put("forest", null);
		}else {
			map.put("forest", forest);
			mapList.put("forest", forest);
		}
		if("".equals(advantage)) {
			map.put("advantage", null);
			mapList.put("advantage", null);
		}else {
			map.put("advantage", advantage);
			mapList.put("advantage", advantage);
		}
		map.put("pageNum", page);
		mapList.put("pageNum", null);
		
		SqlSession session = null;
		List list = null;
		List<AreaInBean> liTotal = null;
		
		try {
			session = this.getSession();
			AreaInDao area = session.getMapper(AreaInDao.class);
			liTotal = area.getAllAreaIn(mapList);
			list = area.getAllAreaIn(map);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			page.setPageData(list);
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
	public int addAreaIn(AreaInBean areaInBean) {
		SqlSession session = null;
		try {
			session = this.getSession();
			AreaInDao area = session.getMapper(AreaInDao.class);
			int num = area.addAreaIn(areaInBean);
			session.commit();
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public List<AreaInBean> getAreaInBySmall() {
		SqlSession session = null;
		List<AreaInBean> area = null;
		try {
			session = this.getSession();
			AreaInDao areaDao = session.getMapper(AreaInDao.class);
			area = areaDao.getAreaInBySmall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}
	@Override
	public List<AreaInBean> getAreaInByName() {
		// TODO Auto-generated method stub
		
		SqlSession session = null;
		List<AreaInBean> area = null;
		try {
			session = this.getSession();
			AreaInDao areaDao = session.getMapper(AreaInDao.class);
			area = areaDao.getAllAreaInByName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return area;
	}

}