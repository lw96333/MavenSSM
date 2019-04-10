package com.java.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.bean.MobileBean;
import com.java.entity.ExtendMobile;

/**
 * <p>
 * 手机号码归属地 服务类
 * </p>
 *
 * @author J164
 * @since 2019-04-10
 */
public interface ExtendMobileService extends IService<ExtendMobile> {
	
	List<MobileBean> selectMobileByCity();
}
