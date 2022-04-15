package com.example2.demo.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.UserRole;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

@Service
public interface UserRoleService extends IService<UserRole>{
    Page<UserRole> getUserRole(Integer page, Integer limit, Integer id);
}
