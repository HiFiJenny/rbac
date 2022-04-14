package com.example2.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {
    @GetMapping({"/login"})
    public String login() {
        return "成功登录login页";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String Code) {
        if ("777".equals(Code)) {
            return "Succeeded";
        }else{
            return "Failed";
        }
    }
}
