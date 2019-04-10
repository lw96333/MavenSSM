package com.one.service.expertConsultation.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.one.bean.PageBean;
import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.dao.expertConsultation.ISpecialistDao;
import com.one.service.expertConsultation.ISpecialistServlce;
import com.one.util.MybatisUtil;

public class SpecialistServlceImp implements ISpecialistServlce{
	
	@Override
	public int addSpecialist(SpecialistManagementBean specialist) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = MybatisUtil.getSession();
			ISpecialistDao isd = session.getMapper(ISpecialistDao.class);
			num = isd.addSpecialist(specialist);
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
	public SpecialistManagementBean getSpecialist(int id) {
		SqlSession session = null;
		SpecialistManagementBean smb = null;
		try {
			session = MybatisUtil.getSession();
			ISpecialistDao isd = session.getMapper(ISpecialistDao.class);
			smb = isd.getSpecialist(id);
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
		return smb;
	}

	@Override
	public int updateSpecialist(int id,String phone,String workUnit,String post,String email) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = MybatisUtil.getSession();
			ISpecialistDao isd = session.getMapper(ISpecialistDao.class);
			SpecialistManagementBean smb = isd.getSpecialist(id);
			smb.setPhone(phone);
			smb.setWorkUnit(workUnit);
			smb.setEmail(email);
			smb.setPost(post);
			num = isd.updateSpecialist(smb);
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
	public int deleteSpecialist(int[] id) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = MybatisUtil.getSession();
			ISpecialistDao isd = session.getMapper(ISpecialistDao.class);
			num = isd.deleteSpecialist(id);
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
	public PageBean<List<SpecialistManagementBean>> getAllSpecialist(int pageNum, int pageSize, String name,
			String expertise, String workUnit,boolean falg) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
	
		if("".equals(name)) {
			map.put("name", null);
			
		}else {
			map.put("name", name);
			
		}
		if("".equals(expertise)) {
			map.put("expertise", null);
			
		}else {
			map.put("expertise", expertise);
			
		}
		if("".equals(workUnit)) {
			map.put("workUnit", null);
			
		}else {
			map.put("workUnit", workUnit);
			
		}

		map.put("pageSize", pageSize);
		
		
		SqlSession session = null;
		List li = null;
		int liTotal = -1;
		PageBean<List<SpecialistManagementBean>> page = new PageBean<>();
		try {
			map.put("pageNum", (pageNum - 1) * pageSize);
			session = MybatisUtil.getSession();
			ISpecialistDao isd = session.getMapper(ISpecialistDao.class);
			li = isd.getAllSpecialist(map);
			page.setPageData(li);
			if(falg) {
				map.remove("pageSize");
				map.remove("pageNum");
				liTotal = isd.getAllSpecialistForNum(map);
				page.setTotalData(liTotal);
				page.setPageNum(pageNum);
				page.setPageSize(pageSize);
				page.setTotalNum((int) Math.ceil((double)page.getTotalData()/pageSize));
			}
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
