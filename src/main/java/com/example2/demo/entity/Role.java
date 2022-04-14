package com.example2.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("role")
public class Role implements Serializable {
    @TableId(value = "role_id", type = IdType.INPUT)
    private String role_id;
    private String role_action;
    private String name;
}
