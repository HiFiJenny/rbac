package com.example2.demo.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example2.demo.entity.User;
import com.example2.demo.entity.mapper.UserMapper;
import com.example2.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Page<User> getUser(Integer page, Integer limit, String id) {
        Page<User> userPage = new Page<>(page, limit);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("id",id);
        userPage = userMapper.getUser(userPage, queryWrapper);
        return userPage;
    }
}