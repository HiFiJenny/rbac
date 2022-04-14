package com.example2.demo.entity.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example2.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
@Component
@Mapper
public interface RoleMapper extends BaseMapper<Role>{
    @Select("select * from role"+
            " ${ew.customSqlSegment}")
    Page<Role> getRole(Page<Role> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
