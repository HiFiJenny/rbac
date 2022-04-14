package com.example2.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/redisTest")
    public Object redisTest(){
        redisTemplate.opsForValue().set("myKey","abc");
        return redisTemplate.opsForValue().get("myKey");
    }
}
