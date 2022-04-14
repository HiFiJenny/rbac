package com.example2.demo.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.Role;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

@Service
public interface RoleService extends IService<Role>{
    Page<Role> getRole(Integer page, Integer limit, String role_id);
}
