package com.infomanage.service.impl;

import com.infomanage.entity.Admin;
import com.infomanage.mapper.AdminMapper;
import com.infomanage.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author seakr
 * @since 2021-06-22
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
