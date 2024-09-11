package com.arian.example.caffeine.api.controller;

import java.util.Map;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.benmanes.caffeine.cache.Cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "1. Caffeine Cache Operations")
@RequestMapping("/cache")
@RestController
@RequiredArgsConstructor
public class CacheController {

   private final CacheManager cacheManager;

   @Operation(summary = "Get cache keys/values")
   @GetMapping("/{cache-name}")
   public Map<Object, Object> getCacheValues(@PathVariable(value = "cache-name") String cacheName) {
      log.info("Calling get keys/values for cache name={}", cacheName);
      com.github.benmanes.caffeine.cache.Cache<Object, Object> nativeCache =
            (Cache<Object, Object>) cacheManager.getCache(cacheName).getNativeCache();
      nativeCache.asMap().forEach((key, value) -> log.info("Key is {} and value {}", key, value));
      return nativeCache.asMap();
   }

   @Operation(summary = "Clear cache keys/values")
   @DeleteMapping("/{cache-name}/clear")
   public void cleanCache(@PathVariable(value = "cache-name") String cacheName) {
      log.info("Calling clean cache name={}", cacheName);
      Optional.ofNullable(cacheName)
              .flatMap(name -> Optional.ofNullable(this.cacheManager.getCache(name)))
              .ifPresent(org.springframework.cache.Cache::clear);
   }

}
