package com.arian.example.hazelcast;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HazelcastExampleApplication {

   public static void main(String[] args) {
      SpringApplication.run(HazelcastExampleApplication.class, args);
   }

}