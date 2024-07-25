package com.linskating.springbootvue_demo.entity;

import lombok.Data;

/**
 * 1. 对于操作数据库的实体类的类名与要操作的表同名
 * 2. 对于表内字段最好也要同名
 */

@Data
public class User{
    private Integer id;
    private String username;
    private String password;
}
