package com.java.service.impl;

import com.java.entity.Online;
import com.java.mapper.OnlineMapper;
import com.java.service.OnlineService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 在线用户统计 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class OnlineServiceImpl extends ServiceImpl<OnlineMapper, Online> implements OnlineService {
	
}
