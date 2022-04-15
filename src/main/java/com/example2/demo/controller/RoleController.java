package com.example2.demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.Role;
import com.example2.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
    public Page getRole(@RequestParam Integer page, Integer limit, Integer id){
        Page<Role> rolePage = roleService.getRole(page,limit,id);
        return rolePage;
    }
    @PostMapping("/api/newRole")
    public Object apinewRole(@RequestParam Integer id, Integer role_id,  Integer status, String name){
        Role role = roleService.getById(id);
        if (role != null){
            return false;
        }else {
            Role r = new Role();
            r.setId(id);
            r.setRole_id(role_id);
            r.setStatus(status);
            r.setName(name);
            return roleService.save(r) ? true:false;
        }
    }

}
