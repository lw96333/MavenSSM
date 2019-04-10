package com.one.service.systemInformation;

import com.one.bean.PageBean;
import com.one.bean.systemInformation.Log_List_Bean;
import com.one.service.systemInformation.Impl.LogServiceImp;
/**
 * 	��־service
 * @author 49160
 *
 */
public interface ILogService {
	
	static ILogService getInstance() {
		return new LogServiceImp();
	}
	/**
	 *	 �õ����е���־����װ��pagebean
	 * @return
	 */
	PageBean<Log_List_Bean> getAllLog(int pageNum,int pageSize,String stratDate,String endDate);
}
