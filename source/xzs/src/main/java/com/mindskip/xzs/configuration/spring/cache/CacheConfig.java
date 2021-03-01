package com.mindskip.xzs.configuration.spring.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

/*
这个类好像只有User的实际类调用了。

@EnableCaching注解是spring framework中的注解驱动的缓存管理功能。
自spring版本3.1起加入了该注解。如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了。

当你在配置类(@Configuration)上使用@EnableCaching注解时，会触发一个post processor，
这会扫描每一个spring bean，查看是否已经存在注解对应的缓存。
如果找到了，就会自动创建一个代理拦截方法调用，使用缓存的bean执行处理。
 */

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * spring boot redis默认序列化方式
     *
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * spring redis 默认生成key方式,包含::号
     *
     * @param prefix
     * @param key
     * @return
     */
    public String simpleKeyGenerator(String prefix, String key) {
        return CacheKeyPrefix.simple().compute(prefix) + key;
    }
}
