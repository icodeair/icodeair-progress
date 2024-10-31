package com.icodeair.progress.service;


import com.icodeair.progress.entity.Progress;
import com.icodeair.progress.util.ProgressConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProgressService {
    @Resource
    private RedisTemplate redisTemplate;

    public Progress get(String key) {
        Object o = redisTemplate.opsForValue().get(ProgressConstant.PROGRESS_KEYS + key);
        if(o != null && o instanceof Progress) {
            return (Progress) o;
        } else {
            return Progress.builder().current(0).success(true).build();
        }
    }
}
