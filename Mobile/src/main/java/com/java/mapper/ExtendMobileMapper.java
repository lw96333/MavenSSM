package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.bean.MobileBean;
import com.java.entity.ExtendMobile;

/**
 * <p>
  * 手机号码归属地 Mapper 接口
 * </p>
 *
 * @author J164
 * @since 2019-04-10
 */
public interface ExtendMobileMapper extends BaseMapper<ExtendMobile> {

	@Select("select city,count(1) as num from extend_mobile GROUP BY city")
	List<MobileBean> selectMobileByCity();
}