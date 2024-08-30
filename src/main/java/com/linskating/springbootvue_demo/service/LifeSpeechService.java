package com.linskating.springbootvue_demo.service;

import com.linskating.springbootvue_demo.entity.LifeSpeech;
import com.linskating.springbootvue_demo.mapper.LifeSpeechMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifeSpeechService {

    private final LifeSpeechMapper lifeSpeechMapper;

    @Autowired
    public LifeSpeechService(LifeSpeechMapper lifeSpeechMapper) {
        this.lifeSpeechMapper = lifeSpeechMapper;
    }

    public List<LifeSpeech> getData(int start, int limit) {
        return lifeSpeechMapper.getData(start,limit);
    }
}
