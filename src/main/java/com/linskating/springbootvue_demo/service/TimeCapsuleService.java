package com.linskating.springbootvue_demo.service;

import com.linskating.springbootvue_demo.entity.TimeCapsule;
import com.linskating.springbootvue_demo.mapper.TimeCapsuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeCapsuleService {

    @Autowired
    TimeCapsuleMapper timeCapsuleMapper;

    public List<TimeCapsule> getData(int limit) {
        return timeCapsuleMapper.getLimitCount(limit);
    }

    public boolean updateLikeStatus(int id, boolean isLike) {
        if (isLike) {
            return timeCapsuleMapper.updateLikeStatus(id, true, 1) >= 1;
        }
        return timeCapsuleMapper.updateLikeStatus(id, false, -1) >= 1;
    }
}
