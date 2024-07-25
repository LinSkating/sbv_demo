package com.linskating.springbootvue_demo.mapper;

import com.linskating.springbootvue_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{

    /**
     * 1. 先检查字段名是否与表字段名相同
     * 2. 在前端请求体里，属性名也要与数据库表字段名相同
     */
    @Insert("insert into `user` (username, password) values (#{username}, #{password})")
    void insertUser(User user);

    @Select("select * from `user` where username = #{username}")
    User selectByName(String username);
}
