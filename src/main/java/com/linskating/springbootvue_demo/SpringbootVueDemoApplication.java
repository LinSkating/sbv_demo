package com.linskating.springbootvue_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.linskating.springbootvue_demo.mapper")
public class SpringbootVueDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootVueDemoApplication.class, args);
    }

}
