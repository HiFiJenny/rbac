package com.example2.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("user_role")
public class UserRole implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private Integer user_id;
    private Integer role_id;
}
