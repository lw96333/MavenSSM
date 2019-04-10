package com.one.service.dataManagement.imp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.PageBean;
import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.dataManagement.RodentpestsBean;
import com.one.dao.dataManagement.InterDataManagement;
import com.one.service.dataManagement.InterDataManagementService;

public class DataManagementServiceImp implements InterDataManagementService {

	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();

	}
	
	@Override
	public int addPests(PestsBean pestsBean) {
		// TODO Auto-generated method stub
		SqlSession session = null ;
		int num = -1;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			num = interDM.addPests(pestsBean);
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
	public PestsBean showPestsInfoById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = null ;
		PestsBean pb = null;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			pb = interDM.showPestsInfoById(id);
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
		return pb;
	}

	@Override
	public int addDiseaseBean(DiseaseBean diseaseBean) {
		// TODO Auto-generated method stub
		SqlSession session = null ;
		int num = -1;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			num = interDM.addDiseaseBean(diseaseBean);
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
	public DiseaseBean showDiseaseBeanInfoById(int id) {
		// TODO Auto-generated method stub
		DiseaseBean db = null ;
		SqlSession session = null ;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			db = interDM.showDiseaseBeanInfoById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
			
		}
		return db;
	}

	@Override
	public int addRodentpestsBean(RodentpestsBean rodentpestsBean) {
		// TODO Auto-generated method stub
		SqlSession session = null ;
		int num = -1;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			num = interDM.addRodentpestsBean(rodentpestsBean);
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
	public RodentpestsBean showRodentpestsBeanInfoById(int id) {
		// TODO Auto-generated method stub
		RodentpestsBean pb = null;
		SqlSession session = null;
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			pb = interDM.showRodentpestsBeanInfoById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.rollback();
			e.printStackTrace();
		}finally{
			if(session !=null){
				session.close();
			}
		}
		return pb;
	}

	@Override
	public PageBean<List<PestsBean>> getAllPestsBeanList(int pageNum, int pageSize, String ThePestisName,
			String TheHost) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
		Map<String,Object> mapTotal = new HashMap();
		if("".equals(ThePestisName)) {
			map.put("ThePestisName", null);
			mapTotal.put("ThePestisName", null);
		}else {
			map.put("ThePestisName", ThePestisName);
			mapTotal.put("ThePestisName", ThePestisName);
		}
		if("".equals(TheHost)) {
			map.put("TheHost", null);
			mapTotal.put("TheHost", null);
		}else {
			map.put("TheHost", TheHost);
			mapTotal.put("TheHost", TheHost);
		}
		mapTotal.put("pageNum", null);
		map.put("pageSize", pageSize);
		mapTotal.put("pageSize", null);
		
		SqlSession session = null;
		List li = null;
		List<PestsBean> liTotal = null;
		PageBean<List<PestsBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			liTotal = interDM.getAllPestsBeanList(mapTotal);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = interDM.getAllPestsBeanList(map);
			page.setPageData(li);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	session.rollback();
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
			
		}
		return page;
	}
	

	@Override
	public PageBean<List<DiseaseBean>> getAllDiseaseBeanList(int pageNum, int pageSize, String TheDiseaseName,
			String TheOnsetSymptom) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
		Map<String,Object> mapTotal = new HashMap();
		if("".equals(TheDiseaseName)) {
			map.put("TheDiseaseName", null);
			mapTotal.put("TheDiseaseName", null);
		}else {
			map.put("TheDiseaseName", TheDiseaseName);
			mapTotal.put("TheDiseaseName", TheDiseaseName);
		}
		if("".equals(TheOnsetSymptom)) {
			map.put("TheOnsetSymptom", null);
			mapTotal.put("TheOnsetSymptom", null);
		}else {
			map.put("TheOnsetSymptom", TheOnsetSymptom);
			mapTotal.put("TheOnsetSymptom", TheOnsetSymptom);
		}
		mapTotal.put("pageNum", null);
		map.put("pageSize", pageSize);
		mapTotal.put("pageSize", null);
		
		SqlSession session = null;
		List li = null;
		List<DiseaseBean> liTotal = null;
		PageBean<List<DiseaseBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			liTotal = interDM.getAllDiseaseBeanList(mapTotal);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = interDM.getAllDiseaseBeanList(map);
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

	@Override
	public PageBean<List<RodentpestsBean>> getAllRodentpestsBeanList(int pageNum, int pageSize, String TheMouseName) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
		Map<String,Object> mapTotal = new HashMap();
		if("".equals(TheMouseName)) {
			map.put("TheMouseName", null);
			mapTotal.put("TheMouseName", null);
		}else {
			map.put("TheMouseName", TheMouseName);
			mapTotal.put("TheMouseName", TheMouseName);
		}
		mapTotal.put("pageNum", null);
		map.put("pageSize", pageSize);
		mapTotal.put("pageSize", null);
		
		SqlSession session = null;
		List li = null;
		List<RodentpestsBean> liTotal = null;
		PageBean<List<RodentpestsBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			InterDataManagement interDM = session.getMapper(InterDataManagement.class);
			liTotal = interDM.getAllRodentpestsBeanList(mapTotal);
			page.setTotalData(liTotal.size());
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = interDM.getAllRodentpestsBeanList(map);
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
