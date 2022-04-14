package com.example2.demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.Role;
import com.example2.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public RoleService roleService;

    public RoleController(JdbcTemplate jdbcTemplate, RoleService roleService){
        this.roleService = roleService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/getRole")
    public Page getRole(@RequestParam Integer page, Integer limit, String role_id){
        Page<Role> rolePage = roleService.getRole(page,limit,role_id);
        return rolePage;
    }
    @PostMapping("/api/newRole")
    public Object apinewRole(@RequestParam String role_id, String role_action, String name){
        Role role = roleService.getById(role_id);
        if (role != null){
            return false;
        }else {
            Role r = new Role();
            r.setRole_id(role_id);
            r.setRole_action(role_action);
            r.setName(name);
            return roleService.save(r) ? true:false;
        }
    }

}
