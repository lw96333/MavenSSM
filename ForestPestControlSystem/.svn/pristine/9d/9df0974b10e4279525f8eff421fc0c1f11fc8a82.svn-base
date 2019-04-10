package com.one.service.systemInformation.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.PageBean;
import com.one.bean.systemInformation.Log_List_Bean;
import com.one.dao.systemInformation.ILogDao;
import com.one.service.systemInformation.ILogService;

public class LogServiceImp implements ILogService{
	
	private SqlSession getSession() throws Exception {
		
		InputStream input = Resources.getResourceAsStream("config/mybatis_config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(input);
		return sqlSession.openSession();
	
	}

	@Override
	public PageBean<Log_List_Bean> getAllLog(int pageNum, int pageSize, String stratDate, String endDate) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<Log_List_Bean> pb = new PageBean<>();
		map.put("pageNum", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("stratDate", stratDate);
		map.put("endDate", endDate);
		SqlSession session = null;
		try {
			session = this.getSession();
			ILogDao log = session.getMapper(ILogDao.class);
			pb.setPageData(log.getAllLog(map));
			pb.setPageNum(pageNum);
			pb.setPageSize(pageSize);
			map.remove("pageNum");
			map.remove("pageSize");
			int num = log.getAllLogForNum(map);
			pb.setTotalData(num);
			pb.setTotalNum((int)Math.ceil(((double)num/pageSize)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return pb;
	}

}
