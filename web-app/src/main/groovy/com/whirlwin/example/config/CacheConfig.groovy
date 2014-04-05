package com.whirlwin.example.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
class CacheConfig {

    @Bean
    CacheManager cacheManager() {
        CacheManager cacheManager = new SimpleCacheManager()
        cacheManager.setCaches([new ConcurrentMapCache("example-cache")])
        cacheManager
    }
}
