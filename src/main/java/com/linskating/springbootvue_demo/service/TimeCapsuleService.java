package com.linskating.springbootvue_demo.service;

import com.linskating.springbootvue_demo.entity.AuthorReaderPreference;
import com.linskating.springbootvue_demo.entity.TimeCapsule;
import com.linskating.springbootvue_demo.mapper.TimeCapsuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TimeCapsuleService {

    @Autowired
    TimeCapsuleMapper timeCapsuleMapper;

    public List<TimeCapsule> getData(int limit, String reader) {
        List<TimeCapsule> limitCount = timeCapsuleMapper.getLimitCount(limit);
        for (TimeCapsule t : limitCount) {
            Boolean curLikeStatus = timeCapsuleMapper.getLikeStatus(reader,t.getAuthor(),t.getSentence());
            t.setLikeStatus(Objects.requireNonNullElse(curLikeStatus, false));
        }
        return limitCount;
    }

    public boolean updateLikeStatus(AuthorReaderPreference arp) {
        if(timeCapsuleMapper.updateLikeStatus(arp.getReader(),arp.getAuthor(),arp.getWorks(),arp.getLikeStatus()) >= 1) {
            return updateTB(arp.getId(),arp.getLikeStatus());
        } else {
            timeCapsuleMapper.insertLikeStatus(arp.getReader(),arp.getAuthor(),arp.getWorks(),arp.getLikeStatus());
        }
        return updateTB(arp.getId(),arp.getLikeStatus());
    }

    public boolean updateTB(int id, boolean isLike) {
        if(isLike) {
            return timeCapsuleMapper.updateTimeCapsuleTB(id,1) >= 1;
        }
        return timeCapsuleMapper.updateTimeCapsuleTB(id,-1) >= 1;
    }
}
