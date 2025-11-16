package dev.duc.tlmse.repository.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RedisCustomRepositoryImpl<T> implements RedisCustomRepository<T> {

    private final RedisMappingContext mappingContext = new RedisMappingContext();;
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public T getValueByKey(String key, Class<T> clazz) {
        Object object = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(object)) {
            return mapper.convertValue(object, clazz);
        }
        throw new RuntimeException("Entity not found");
    }
}
