package com.lin.canteen.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.canteen.bean.Consume;
import com.lin.canteen.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private String CANTEEN_CONSUME = "CONSUME:";
    private boolean REDIS_STATUS = true;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean expire(String key, long time) {
        key = CANTEEN_CONSUME + key;
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setAndExpire(String key, Object value, long time) {
        key = CANTEEN_CONSUME + key;
        try {
            if (time > 0) {
                stringRedisTemplate.opsForValue().set(key, JsonUtils.objectToJson(value), time, TimeUnit.SECONDS);
            } else {
                stringRedisTemplate.opsForValue().set(key, JsonUtils.objectToJson(value));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String get(String key) {
        if (REDIS_STATUS) {
            key = CANTEEN_CONSUME + key;
            return stringRedisTemplate.opsForValue().get(key);
        } else {
            return null;
        }
    }

    public boolean hSet(String key, String item, Object value) {
        key = CANTEEN_CONSUME + key;
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hSetExpire(String key, String item, Object value, long time) {
        key = CANTEEN_CONSUME + key;
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Consume> hGetValue(String key) {
        key = CANTEEN_CONSUME + key;
        ArrayList<Consume> consume = new ArrayList<>();
        Object o = redisTemplate.opsForValue().get(key);
        consume = new ObjectMapper().convertValue(o, consume.getClass());
        return consume;
    }

    public Object hget(String key, String item) {
        key = CANTEEN_CONSUME + key;
        return redisTemplate.opsForHash().get(key, item);
    }

}
