package com.linskating.springbootvue_demo.mapper;

import com.linskating.springbootvue_demo.entity.TimeCapsule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TimeCapsuleMapper {

    @Select("SELECT * FROM timecapsule ORDER BY RAND() LIMIT #{limit}")
    List<TimeCapsule> getLimitCount(int limit);

    @Update("update timecapsule set isLike = #{isLike}, star = star + #{cut} where id = #{id}")
    int updateLikeStatus(int id, boolean isLike, int cut);
}
