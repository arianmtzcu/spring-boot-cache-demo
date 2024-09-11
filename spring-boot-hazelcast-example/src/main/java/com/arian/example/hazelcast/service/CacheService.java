package com.arian.example.hazelcast.service;

import static com.arian.example.hazelcast.util.Constants.CACHE_NAME1;

import java.util.UUID;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@CacheConfig(cacheNames = CACHE_NAME1)
@RequiredArgsConstructor
public class CacheService {

   private final HazelcastInstance hazelcastInstance;

   @Cacheable(value = CACHE_NAME1, key = "#key")
   public String getData(final String key) throws InterruptedException {
      log.info("Running sleep action :: 2 seconds");
      Thread.sleep(2000);
      return String.valueOf(generateUUID(key));
   }

   private UUID generateUUID(final String key) {
      final UUID uuid = UUID.randomUUID();
      log.info(String.format("Saving value action :: key=%s --> uuid=%s", key, uuid));
      return uuid;
   }

   public Boolean existValueIntoCache(final String uuid) {
      return hazelcastInstance.getMap(CACHE_NAME1).containsValue(uuid);
   }

   public IMap<Object, Object> getAllValuesIntoCache() {
      return hazelcastInstance.getMap(CACHE_NAME1);
   }

}
