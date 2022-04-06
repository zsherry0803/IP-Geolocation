package com.ip.demo.service;

import com.ip.demo.model.IpResponse;
import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager() {
        return new SpringCache2kCacheManager()
                .addCaches(
                        b->b.name("query").keyType(String.class).valueType(IpResponse.class)
                                .expireAfterWrite(1, TimeUnit.MINUTES)
                                .entryCapacity(5000));
    }
}