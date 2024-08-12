package com.linskating.springbootvue_demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DropDriftBottleMapper {
    @Insert("insert into timecapsule (username,sentence,star,view,common) values (#{username},#{sentence},0,0,0)")
    int setDropDriftBottle(String username, String sentence);
}
