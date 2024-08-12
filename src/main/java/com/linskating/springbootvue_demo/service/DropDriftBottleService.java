package com.linskating.springbootvue_demo.service;

import com.linskating.springbootvue_demo.mapper.DropDriftBottleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DropDriftBottleService {

    @Autowired
    DropDriftBottleMapper dropDriftBottleMapper;

    public boolean setDropDriftBottle(String username, String sentence) {
        return dropDriftBottleMapper.setDropDriftBottle(username,sentence) >= 1;
    }

}