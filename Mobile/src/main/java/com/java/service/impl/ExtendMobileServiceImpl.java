package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.bean.MobileBean;
import com.java.entity.ExtendMobile;
import com.java.mapper.ExtendMobileMapper;
import com.java.service.ExtendMobileService;

/**
 * <p>
 * 手机号码归属地 服务实现类
 * </p>
 *
 * @author J164
 * @since 2019-04-10
 */
@Service
public class ExtendMobileServiceImpl extends ServiceImpl<ExtendMobileMapper, ExtendMobile> implements ExtendMobileService {

	@Autowired
	private ExtendMobileMapper extendMobileMapper;
	
	@Override
	public List<MobileBean> selectMobileByCity() {
		// TODO Auto-generated method stub
		return extendMobileMapper.selectMobileByCity();
	}
	
}
