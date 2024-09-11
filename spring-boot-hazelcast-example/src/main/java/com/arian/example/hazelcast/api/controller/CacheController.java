package com.arian.example.hazelcast.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arian.example.hazelcast.service.CacheService;
import com.hazelcast.map.IMap;

import lombok.RequiredArgsConstructor;

@Tag(name = "1. Hazelcast Cache Operations")
@RestController
@RequestMapping(path = "/cache")
@RequiredArgsConstructor
public class CacheController {

   private final CacheService cacheService;

   @GetMapping(value = "/greet")
   public ResponseEntity<String> sayHello() {
      return new ResponseEntity<>("Hello World!", HttpStatus.OK);
   }

   @GetMapping(value = "/generate/{word}")
   public ResponseEntity<String> getResult(@PathVariable("word") String word) throws InterruptedException {
      return new ResponseEntity<>(cacheService.getData(word), HttpStatus.CREATED);
   }

   @GetMapping(value = "/find/{uuid}")
   public ResponseEntity<Boolean> existValueIntoCache(@PathVariable("uuid") String uuid) {
      return cacheService.existValueIntoCache(uuid) ? new ResponseEntity<>(true, HttpStatus.OK) : new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
   }

   @GetMapping(value = "/find/all", produces = "application/json")
   public ResponseEntity<IMap<Object, Object>> getAllValuesIntoCache() {
      final var values = cacheService.getAllValuesIntoCache();
      return !values.isEmpty() ? new ResponseEntity<>(values, HttpStatus.OK) : new ResponseEntity<>(values, HttpStatus.NO_CONTENT);
   }

}
