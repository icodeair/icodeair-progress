package com.icodeair.progress.controller;


import com.icodeair.progress.annotation.HytProgress;
import com.icodeair.progress.util.ProgressManager;
import com.icodeair.progress.entity.Result;
import com.icodeair.progress.service.ProgressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Resource
    private ProgressService progressService;
    @Resource
    private ProgressManager progressManager;

    @GetMapping("/get")
    public Result get(@RequestParam String key) {
        return Result.success(progressService.get(key));
    }

    @GetMapping("/test")
    @HytProgress
    public void test() {
        progressManager.finish("111");
    }

}
