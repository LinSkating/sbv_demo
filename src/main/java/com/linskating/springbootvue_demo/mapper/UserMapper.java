package com.linskating.springbootvue_demo.mapper;

import com.linskating.springbootvue_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper{

    /**
     * 1. 先检查字段名是否与表字段名相同
     * 2. 在前端请求体里，属性名也要与数据库表字段名相同
     */

    // 插入新用户
    @Insert("insert into `user` (username, password) values (#{username}, #{password})")
    void insertUser(User user);

    // 查找判断是否存在该用户名
    @Select("select * from `user` where username = #{username}")
    User selectByName(String username);

    @Update("update `user` set password = #{password} where username = #{username}")
    void setPassword(String username, String password);
}
