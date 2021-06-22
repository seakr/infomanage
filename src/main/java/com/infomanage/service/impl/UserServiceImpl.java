package com.infomanage.service.impl;

import com.infomanage.entity.User;
import com.infomanage.mapper.UserMapper;
import com.infomanage.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
