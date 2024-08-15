package com.linskating.springbootvue_demo.mapper;

import com.linskating.springbootvue_demo.entity.TimeCapsule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TimeCapsuleMapper {

    @Select("SELECT * FROM timecapsule ORDER BY RAND() LIMIT #{limit}")
    List<TimeCapsule> getLimitCount(int limit);

    @Update("update timecapsule set star = star + #{cut} where id = #{id}")
    int updateTimeCapsuleTB(int id, int cut);

    @Insert("insert into isliketable (reader,author,works,likeStatus) values (#{reader},#{author},#{works},#{likeStatus})")
    void insertLikeStatus(String reader, String author, String works, Boolean likeStatus);

    @Update("update isliketable set likeStatus = #{likeStatus} where reader = #{reader} and author = #{author} and works = #{works}")
    int updateLikeStatus(String reader, String author, String works, Boolean likeStatus);

    @Select("select ifnull(likeStatus, false) from isliketable where reader = #{reader} and author = #{author} and works = #{works}")
    Boolean getLikeStatus(String reader, String author, String works);
}
