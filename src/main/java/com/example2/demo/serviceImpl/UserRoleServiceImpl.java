package com.example2.demo.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example2.demo.entity.Role;
import com.example2.demo.entity.UserRole;
import com.example2.demo.entity.mapper.UserRoleMapper;
import com.example2.demo.entity.mapper.UserRoleMapper;
import com.example2.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public Page<UserRole> getUserRole(Integer page, Integer limit, Integer id) {
        Page<UserRole> userRolePage = new Page<>(page, limit);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("id",id);
//                    .groupBy("role_id");
        userRolePage = userRoleMapper.getUserRole(userRolePage, queryWrapper);
        return userRolePage;
    }
}