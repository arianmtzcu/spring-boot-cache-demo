package com.arian.example.caffeine.config;

import static com.arian.example.caffeine.util.Constants.USER_CACHE;
import static java.util.concurrent.TimeUnit.HOURS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {

   @Value("${cache.users.info.ttl}")
   private long cacheUsersInfoTtl;

   @Value("${cache.users.info.max-size}")
   private long cacheUsersInfoMaxSize;

   @Bean
   public CacheManager cacheManager() {
      final List<CaffeineCache> caches = new ArrayList<>();
      caches.add(buildCache(USER_CACHE, cacheUsersInfoTtl, HOURS, cacheUsersInfoMaxSize));

      final SimpleCacheManager manager = new SimpleCacheManager();
      manager.setCaches(caches);
      return manager;
   }

   private static CaffeineCache buildCache(String name, long ttl, TimeUnit ttlUnit, long size) {
      return new CaffeineCache(name, Caffeine.newBuilder().expireAfterWrite(ttl, ttlUnit)
                                             //.expireAfterAccess(ttl, ttlUnit)
                                             .maximumSize(size).build());
   }
}