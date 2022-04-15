package com.example2.demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.UserRole;
import com.example2.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserRoleController {
    @Autowired
    public UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }
    /**
     * Description 获取指定用户的所有角色
     *
     * @param
     * @return
     * @Author HiFi
     */
    @GetMapping("/api/getUserRole")
    public Page getUserRole(@RequestParam Integer page, Integer limit, Integer id){
        Page<UserRole> userRolePage = userRoleService.getUserRole(page,limit,id);
        return userRolePage;
    }
}
