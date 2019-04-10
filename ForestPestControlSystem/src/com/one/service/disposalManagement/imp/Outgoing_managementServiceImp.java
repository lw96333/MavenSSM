package com.one.service.disposalManagement.imp;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.NameOfGoodsBean;
import com.one.bean.PageBean;
import com.one.bean.PestTypesBean;
import com.one.bean.TypeBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.bean.disposalManagement.Outgoing_managementBean;
import com.one.dao.disposalManagement.Outgoing_managementDao;
import com.one.service.disposalManagement.Outgoing_managementService;

public class Outgoing_managementServiceImp implements Outgoing_managementService {

	private SqlSession getSession() throws Exception {
		InputStream inputStream = null;
		inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory.openSession();
	}

	@Override
	public PageBean<Outgoing_managementBean> getShowOutGoing(int pageNum, int pageSize, String dateStrat, String dateEnd) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		
		Map<String,Object> map = new HashMap<>();
		
		PageBean<Outgoing_managementBean> pb = new PageBean<>();
		map.put("pageNum", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("dateStrat", dateStrat);
		map.put("dateEnd", dateEnd);
//		System.out.println(map+"33333333333");
		try {
		    session = this.getSession();
		    Outgoing_managementDao omd = session.getMapper(Outgoing_managementDao.class);
		    List<Outgoing_managementBean> li = omd.getAllOutGoing(map);
		    pb.setPageData(li);
		    map.remove("pageNum");
		    map.remove("pageSize");
		    pb.setTotalData(omd.getAllOutGoingForNumber(map));
		    pb.setPageSize(pageSize);
		    pb.setPageNum(pageNum);
		    pb.setTotalNum((int) Math.ceil((double)pb.getTotalData()/pageSize));
//		    System.out.println(pb+"1232324");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return pb;
	}
	
	

	@Override
	public Integer addOutGoing(Outgoing_managementBean omb) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int num = -1;
		try {
			session = this.getSession();
			Outgoing_managementDao omd = session.getMapper(Outgoing_managementDao.class);
			num = omd.addOutGoing(omb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return num;
	}

	@Override
	public Map<String, Object> getAll() {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Map<String,Object> map2 = new HashMap<>();
		try {
			session = this.getSession();
			Outgoing_managementDao omd = session.getMapper(Outgoing_managementDao.class);
			List<NameOfGoodsBean> name =  omd.getAllNameOfGoodsBean();
			List<PestTypesBean> PestType =  omd.getAllPestTypesBean();
			List<SmallClassManagementBean> small =  omd.getAllSmallClassManagementBean();
			List<TypeBean> type =  omd.getAllTypeBean();
			map2.put("name", name);
			map2.put("PestType", PestType);
			map2.put("small", small);
			map2.put("type", type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return map2;
	}
	
	
 }
