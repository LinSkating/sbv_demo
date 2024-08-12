package com.linskating.springbootvue_demo.controller;

import com.linskating.springbootvue_demo.common.Result;
import com.linskating.springbootvue_demo.entity.DriftBottle;
import com.linskating.springbootvue_demo.service.DropDriftBottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class DropDriftBottleController {

    @Autowired
    DropDriftBottleService dropDriftBottleService;

    @PostMapping("/DropDriftBottle")
    public Result setDriftBottle(@RequestBody DriftBottle driftBottle) {
        if(dropDriftBottleService.setDropDriftBottle(driftBottle.getUsername(),driftBottle.getSentence())) {
            return Result.success();
        }
        return Result.error("500","上传失败");
    }
}
