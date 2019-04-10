package com.one.test.disposalManagement;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.one.bean.NameOfGoodsBean;
import com.one.bean.PestTypesBean;
import com.one.bean.TypeBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.bean.disposalManagement.Outgoing_managementBean;
import com.one.dao.disposalManagement.Outgoing_managementDao;

public class Outgoing_managementTest {

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
		public void testGetAllOutGoing() {
			// TODO Auto-generated method stub
			Outgoing_managementDao outDao = session.getMapper(Outgoing_managementDao.class);
			Map<String,Object> map = new HashMap();
			map.put("pageNum", 0);
			map.put("pageSize", 2);
			map.put("dateStrat", "2000-08-11");
			map.put("dateEnd", "2020-08-11");
			List<Outgoing_managementBean> out = outDao.getAllOutGoing(map);
			System.out.println(out.size());
			System.out.println("============");
			session.close();
		}
		
		@Test
		public void testAddOutGoing() {
			// TODO Auto-generated method stub
			Outgoing_managementDao outDao = session.getMapper(Outgoing_managementDao.class);
			Outgoing_managementBean outBean = new Outgoing_managementBean();
			SmallClassManagementBean sBean = new SmallClassManagementBean();
			sBean.setId(1);
			outBean.setId(sBean);
			
			PestTypesBean pb = new PestTypesBean();
			pb.setInsectId(2);
			outBean.setInsect(pb);
			
			TypeBean tb = new TypeBean();
			tb.setTypeId(1);
			outBean.setType(tb);
			
			outBean.setNum(100);
			outBean.setPurpoose("”√Õæ");
			outBean.setDate("2013-04-14");
			outBean.setPersonName("’≈ŒÚ");
			NameOfGoodsBean nb = new NameOfGoodsBean();
			nb.setGoodsId(1);
			outBean.setGoods(nb);
			
			outDao.addOutGoing(outBean);
			session.commit();
		}
}
