package com.example2.demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example2.demo.entity.Role;
import com.example2.demo.entity.User;
import com.example2.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public UserService userService;

    public UserController(JdbcTemplate jdbcTemplate,UserService userService){
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * Description JDBC CRUD
     *
     * @param
     * @return
     * @Author HiFi
     */
    @PostMapping("/newUser")
    public void newUser(@RequestParam Integer id, String username, String password, Integer status){
        jdbcTemplate.update("insert into user(id, username, password, status) values (?,?,?)",
                id, username, password, status);
    }
    @GetMapping("/getUserList")
    public List<Map<String, Object>> getUserList(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list;
    }
    @GetMapping("/deleteUserByid")
    public void getUserList(@RequestParam Integer id){
        jdbcTemplate.update("delete from user where id = ?",id);
    }
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestParam Integer id, String password){
        jdbcTemplate.update("update user set password = ? where id = ?",id, password);
    }
    /**
     * Description mybatis CRUD
     *
     * @param
     * @return
     * @Author HiFi
     */
    @PostMapping("/api/updatePassword")
    public Object apiupdatePassword(@RequestParam Integer id, String pd){
        User user = userService.getById(id);
        if (user == null){
            return false;
        }else {
            User u = user;
            u.setPassword(pd);
            return userService.updateById(u) ? true:false;
        }
    }
    @GetMapping("/api/getUser")
    public Page getUser(@RequestParam Integer page, Integer limit, Integer id){
        Page<User> userPage = userService.getUser(page,limit,id);
        return userPage;
    }

    @PostMapping("/api/newUser")
    public Object apinewUser(@RequestParam Integer id, String username, String pd, Integer status){
        User user = userService.getById(id);
        if (user != null){
            return false;
        }else {
            User u = new User();
            u.setId(id);
            u.setUsername(username);
            u.setPassword(pd);
            u.setStatus(status);
            return userService.save(u) ? true:false;
        }
    }
    @PostMapping("/api/delete")
    public Object delete(@RequestParam Integer id){
        User user = userService.getById(id);
        if (user == null){
            return false;
        }else {
            return userService.removeById(id) ? true:false;
        }
    }
}
