package cn.mobiledaily.hisforce.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by Johnson on 2015/11/24.
 */
@Repository(value = "redisRepository")
public class RedisRepository {
    @Inject
    private RedisTemplate<String, Long> redisTemplate;

    public void addForZSet(String key, Long value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    public void removeFromZSet(String key, Long value) {
        redisTemplate.opsForZSet().remove(key, value);
    }

    public Set<Long> members(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }
}
