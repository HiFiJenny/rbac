package com.example2.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private String username;
    private String password;
    private Integer status;
}
