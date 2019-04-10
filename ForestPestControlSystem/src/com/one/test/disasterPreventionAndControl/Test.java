//package com.one.test.disasterPreventionAndControl;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//
//import com.one.bean.DisasterStageBean;
//import com.one.bean.DiscoveryPathBean;
//import com.one.bean.LandClassBean;
//import com.one.bean.LocationBean;
//import com.one.bean.PageBean;
//import com.one.bean.PestTypesBean;
//import com.one.bean.disasterPreventionAndControl.AreaInBean;
//import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
//import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
//import com.one.dao.disasterPreventionAndControl.AreaInDao;
//import com.one.dao.disasterPreventionAndControl.IncidentRecordDao;
//import com.one.dao.disasterPreventionAndControl.SmallClassManagementDao;
//
//public class Test {
//
//	private AreaInDao area = null;
//
//	private SmallClassManagementDao sma = null;
//	
//	private IncidentRecordDao inci = null;
//
//	private SqlSession sion = null;
//
//	@Before
//	public void init() {
//
//		InputStream in = null;
//
//		try {
//			in = Resources.getResourceAsStream("config/mybatis_config.xml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//
//		sion = factory.openSession();
//
//		area = sion.getMapper(AreaInDao.class);
//		sma = sion.getMapper(SmallClassManagementDao.class);
//		inci = sion.getMapper(IncidentRecordDao.class);
//	}
//
//	@org.junit.Test
//	public void testGetAllAreaIn() {
//		
//		PageBean<AreaInBean> page = new PageBean<>();
//		
//		page.setPageNum(1);
//		
//		page.setPageSize(3);
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		map.put("forest", "一号");
//
//		map.put("advantage", "柏");
//		
//		map.put("pageNum", page);
//
//		page.setPageData(area.getAllAreaIn(map));
//
//		List<AreaInBean> list = page.getPageData();
//
//		for (AreaInBean areaInBean : list) {
//
//			System.out.println(areaInBean);
//		}
//		
//		System.out.println(area.countAllAreaIn());
//	}
//
//	@org.junit.Test
//	public void testGetAllSmallClassManagement() {
//		Map<String, String> map = new HashMap<String, String>();
//
//		map.put("smName", "一");
//
//		map.put("regName", "雅");
//
//		PageBean<SmallClassManagementBean> page = new PageBean<>();
//
//		page.setPageData(sma.getAllSmallClassManagement(map));
//
//		List<SmallClassManagementBean> list = page.getPageData();
//
//		for (SmallClassManagementBean areaInBean : list) {
//
//			System.out.println(areaInBean);
//		}
//	}
//
//	@org.junit.Test
//	public void testCountAllSmallClassManagement() {
//		
//		int pageSize = sma.countAllSmallClassManagement();
//
//		System.out.println(pageSize);
//		
//	}
//	
//	@org.junit.Test
//	public void testGetSmallClassInfoById(){
//		
//		SmallClassManagementBean small = sma.getSmallClassInfoById(2);
//		
//		System.out.println(small);
//	}
//	
//	@org.junit.Test
//	public void testAddAreaIn(){
//		
//		AreaInBean a = new AreaInBean();
//		a.setAdvantage("松树");
//		a.setForest("针阔林");
//		a.setName("雅林二号地区");
//		LandClassBean land = new LandClassBean();
//		land.setLandId(1);
//		land.setName("林地");
//		a.setLinDi(land);
//		area.addAreaIn(a);
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testUpdateSmallClassById(){
//		SmallClassManagementBean small = new SmallClassManagementBean();
//		small.setPersonName("杨再兴");
//		small.setId(3);
//		small.setPersonPhone("13255556666");
//		sma.updateSmallClassById(small);
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testAddSmallClass(){
//		SmallClassManagementBean sc = new SmallClassManagementBean();
//		sc.setName("卧龙二班");
//		sc.setPersonName("张冀川");
//		sc.setPersonNum(8);
//		sc.setPersonPhone("13356464587");
//		LandClassBean land = new LandClassBean();
//		land.setLandId(3);
//		sc.setLand(land);
//		AreaInBean a = new AreaInBean();
//		a.setAreaId(6);
//		sc.setAreaIn(a);
//		sma.addSmallClass(sc);
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testGetAllIncidentRecord(){
//		Map<String, String> map = new HashMap<String, String>();
//
//		/*map.put("eventName", "毛");
//
//		map.put("typeName", "防");
//		
//		map.put("path", "三");*/
//
//		PageBean<IncidentRecordBean> page = new PageBean<>();
//
//		page.setPageData(inci.getAllIncidentRecord(map));
//
//		List<IncidentRecordBean> list = page.getPageData();
//
//		for (IncidentRecordBean areaInBean : list) {
//
//			System.out.println(areaInBean);
//		}
//	}
//	
//	@org.junit.Test
//	public void testUpdateIncidentRecord(){
//		IncidentRecordBean incident = new IncidentRecordBean();
//		incident.setId(1);
//		incident.setDisaster("1111");
//		DisasterStageBean dis = new DisasterStageBean();
//		dis.setStageId(1);
//		dis.setTypeName("已经得到控制");
//		incident.setStage(dis);
//		inci.updateIncidentRecord(incident);
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testAddIncidentRecord(){
//		IncidentRecordBean incident = new IncidentRecordBean();
//		incident.setControlMethod("大量放置捕鼠夹");
//		incident.setTime("2010-12-01");
//		incident.setPic("1.png");
//		inci.addIncidentRecord(incident);
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testGetIncidentRecordById(){
//		IncidentRecordBean incident = inci.getIncidentRecordById(1);
//		
//		System.out.println(incident);
//	}
//	
//	@org.junit.Test
//	public void testApplyForExpertReview(){
//		
//		inci.applyForExpertReview(3);
//		
//		sion.commit();
//	}
//	
//	@org.junit.Test
//	public void testCountAllIncidentRecord(){
//		
//		int i = inci.countAllIncidentRecord();
//		
//		System.out.println(i);
//	}
//	
//	@org.junit.Test
//	public void testgetIncidentRecordByDate(){
//		Map<String,String> info = new HashMap<String,String>();
//		info.put("beginTime","2010-10-10");
//		info.put("overTime", "2019-10-10");
//		PageBean<IncidentRecordBean> page = new PageBean<>();
//
//		page.setPageData(inci.getIncidentRecordByDate(info));
//
//		List<IncidentRecordBean> list = page.getPageData();
//
//		for (IncidentRecordBean areaInBean : list) {
//
//			System.out.println(areaInBean);
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
