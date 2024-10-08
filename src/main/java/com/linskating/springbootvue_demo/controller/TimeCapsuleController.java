package com.linskating.springbootvue_demo.controller;

import com.linskating.springbootvue_demo.common.Result;
import com.linskating.springbootvue_demo.entity.AuthorReaderPreference;
import com.linskating.springbootvue_demo.entity.TimeCapsule;
import com.linskating.springbootvue_demo.service.TimeCapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class TimeCapsuleController {

    private final TimeCapsuleService timeCapsuleService;

    @Autowired
    public TimeCapsuleController(TimeCapsuleService timeCapsuleService) {
        this.timeCapsuleService = timeCapsuleService;
    }

    @GetMapping("/timeTravel")
    public List<TimeCapsule> getTimeCapsuleData(@RequestParam Integer limit, @RequestParam String reader) {
        return timeCapsuleService.getData(limit, reader);
    }

    @PutMapping("/timeTravel/updateLikeStatus")
    public Result updateLikeStatus(@RequestBody AuthorReaderPreference authorReaderPreference) {
        if (timeCapsuleService.updateLikeStatus(authorReaderPreference)) {
            return Result.success();
        }
        return Result.error("400", "该帖子的id不存在");
    }

    @PutMapping("/timeTravel/updateView")
    public Result updateViewInfo(@RequestBody TimeCapsule timeCapsule) {
        if (timeCapsuleService.updateViewInfo(timeCapsule.getId())) {
            return Result.success();
        }
        return Result.error("该帖子可能不存在");
    }
}
