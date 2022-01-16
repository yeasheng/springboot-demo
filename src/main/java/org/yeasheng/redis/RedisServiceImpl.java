package org.yeasheng.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * RedisService
 *
 * @author yansh
 * @version 2022/1/16
 **/
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return obj == null ? "": obj.toString();
    }

    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public void executePipelined(Map<String, String> map, long seconds) {

        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

        redisTemplate.executePipelined((RedisCallback<Object>) redisConnection -> {
            map.forEach((key, value) -> redisConnection.set(serializer.serialize(key), serializer.serialize(value),
                    Expiration.seconds(seconds), RedisStringCommands.SetOption.UPSERT));
            return null;
        }, serializer);

    }
}
