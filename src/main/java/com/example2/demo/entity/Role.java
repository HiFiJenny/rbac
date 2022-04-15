package com.example2.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("role")
public class Role implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private Integer role_id;
    private Integer status;
    private String name;
}
