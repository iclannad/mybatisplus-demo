package com.glinet.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glinet.mybatisplus.entity.User;
import com.glinet.mybatisplus.mapper.SysUserMapper;
import com.glinet.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, User> implements UserService {
}
