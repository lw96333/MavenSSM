package com.java.service.impl;

import com.java.entity.Complaint;
import com.java.mapper.ComplaintMapper;
import com.java.service.ComplaintService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投诉表 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {
	
}
