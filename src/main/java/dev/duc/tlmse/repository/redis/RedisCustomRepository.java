package dev.duc.tlmse.repository.redis;

public interface RedisCustomRepository<T> {

    T getValueByKey(String key, Class<T> clazz);

//    String getFullKey(UUID roleId, Class<T> clazz);

}
