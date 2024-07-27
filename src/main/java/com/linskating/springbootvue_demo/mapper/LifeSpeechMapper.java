package com.linskating.springbootvue_demo.mapper;

import com.linskating.springbootvue_demo.entity.LifeSpeech;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LifeSpeechMapper {

    @Select("SELECT * FROM `lifespeech` LIMIT #{start}, #{limit}")
    List<LifeSpeech> getData(int start, int limit);
}
