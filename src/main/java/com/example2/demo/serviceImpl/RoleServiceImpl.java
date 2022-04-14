package com.example2.demo.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example2.demo.entity.Role;
import com.example2.demo.entity.mapper.RoleMapper;
import com.example2.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Page<Role> getRole(Integer page, Integer limit, String id) {
        Page<Role> rolePage = new Page<>(page, limit);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("role_id",id);
        rolePage = roleMapper.getRole(rolePage, queryWrapper);
        return rolePage;
    }
}