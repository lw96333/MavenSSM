package com.one.service.expertConsultation.imp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.bean.expertConsultation.InstrumentManagementBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.dao.expertConsultation.IInstrumentManagementDao;
import com.one.dao.expertConsultation.ISpecialistDao;
import com.one.service.expertConsultation.IInstrumentManagementService;

public class InstrumentManagementServiceImp implements IInstrumentManagementService{

	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();

	}

	@Override
	public int addInstrumentManagement(InstrumentManagementBean imb) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = this.getSession();
			IInstrumentManagementDao isd = session.getMapper(IInstrumentManagementDao.class);
			num = isd.addInstrumentManagement(imb);
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
	public PageBean<List<IncidentRecordBean>> getIncidentRecordByStageId(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap();
		map.put("pageSize", pageSize);
		SqlSession session = null;
		List li = null;
		int liTotal = -1;
		PageBean<List<IncidentRecordBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			IInstrumentManagementDao iim = session.getMapper(IInstrumentManagementDao.class);
			liTotal = iim.getIncidentRecordByStageIdForNum();
			page.setTotalData(liTotal);
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = iim.getIncidentRecordByStageId(map);
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
	public IncidentRecordBean getIncidentRecordById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		IncidentRecordBean irb = null;
		try {
			session = this.getSession();
			IInstrumentManagementDao isd = session.getMapper(IInstrumentManagementDao.class);
			irb = isd.getIncidentRecordById(id);
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
		return irb;
	}

	@Override
	public PageBean<List<InstrumentManagementBean>> getInstrumentManagement(int pageNum, int pageSize,int id) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap();
		map.put("pageSize", pageSize);
		map.put("id", id);
		SqlSession session = null;
		List li = null;
		int liTotal = -1;
		PageBean<List<InstrumentManagementBean>> page = new PageBean<>();
		try {
			session = this.getSession();
			IInstrumentManagementDao iim = session.getMapper(IInstrumentManagementDao.class);
			liTotal = iim.getInstrumentManagementForNum(id);
			page.setTotalData(liTotal);
			page.setPageNum(pageNum);
			page.setPageSize(pageSize);
			page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			map.put("pageNum", (pageNum - 1) * pageSize);
			li = iim.getInstrumentManagement(map);
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
	public List<IncidentRecordBean> getIncidentRecordForExcel() {
		// TODO Auto-generated method stub
		SqlSession session = null;
		List<IncidentRecordBean> li = null;
		try {
			session = this.getSession();
			IInstrumentManagementDao iim = session.getMapper(IInstrumentManagementDao.class);
			li = iim.getIncidentRecordForExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
			
		}
		
		return li;
	}
	

}
