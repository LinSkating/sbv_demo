package com.linskating.springbootvue_demo.controller;

import com.linskating.springbootvue_demo.entity.LifeSpeech;
import com.linskating.springbootvue_demo.service.LifeSpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class LifeSpeechController {
    @Autowired
    LifeSpeechService lifeSpeechService;

    @GetMapping("/lifeSpeech")
    public List<LifeSpeech> getLifeSpeechData(@RequestParam int start, @RequestParam int limit) {
        return lifeSpeechService.getData(start,limit);
    }
}
