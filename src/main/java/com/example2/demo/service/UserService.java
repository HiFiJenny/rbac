package com.example2.demo.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.User;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

@Service
public interface UserService extends IService<User>{
    Page<User> getUser(Integer page, Integer limit, String id);
}
