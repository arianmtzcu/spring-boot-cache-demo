package com.arian.example.redis.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Tag(name = "1. Redis Cache Operations")
@RestController
@RequestMapping("/cache")
@RequiredArgsConstructor
public class CacheController {

   private final CacheManager cacheManager;

   @PatchMapping("/{cache-name}")
   public void evictCache(@PathVariable("cache-name") String name) {
      this.cacheManager.getCache(name).clear();
   }

}